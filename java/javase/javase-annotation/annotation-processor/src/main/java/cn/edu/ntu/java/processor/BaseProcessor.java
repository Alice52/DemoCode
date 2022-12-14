package cn.edu.ntu.java.processor;

import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @author zack <br>
 * @create 2022-12-13 22:38 <br>
 * @project javase <br>
 */
public abstract class BaseProcessor extends AbstractProcessor {

    private static final Logger log = LoggerFactory.getLogger(BaseProcessor.class);

    public JavacTrees trees;
    public TreeMaker treeMaker;
    public Names names;

    public List<Function<JCTree.JCVariableDecl, JCTree.JCMethodDecl>> customs = new ArrayList<>();

    protected abstract Class<? extends Annotation> anno();

    protected abstract void initCustom();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        TreeTranslator translator =
                new TreeTranslator() {
                    @Override
                    public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {

                        jcClassDecl.defs.stream()
                                .filter(jcTree1 -> jcTree1.getKind().equals(Tree.Kind.VARIABLE))
                                .map(jcTree2 -> (JCTree.JCVariableDecl) jcTree2)
                                .forEach(
                                        jcVariableDecl -> {
                                            customs.forEach(
                                                    x -> {
                                                        jcClassDecl.defs =
                                                                jcClassDecl.defs.prepend(
                                                                        x.apply(
                                                                                jcVariableDecl));

                                                        log.info("aaa: {}", x);
                                                    }
                                                        );
                                        });

                        super.visitClassDef(jcClassDecl);
                    }
                };

        roundEnv.getElementsAnnotatedWith(anno()).stream()
                .map(element -> trees.getTree(element))
                .forEach(jcTree -> jcTree.accept(translator));

        return true;
    }
}
