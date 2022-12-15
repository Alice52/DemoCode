package cn.edu.ntu.java.processor;

import cn.edu.ntu.java.annotations.Serial;
import cn.hutool.core.util.RandomUtil;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.code.Types;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author alice52
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("cn.edu.ntu.java.annotations.Serial")
public class SerialProcessor extends AbstractProcessor {
    private static final Logger log = LoggerFactory.getLogger(SerialProcessor.class);
    public JavacTrees trees;
    public TreeMaker treeMaker;
    public Names names;
    long serialNumber = RandomUtil.randomLong(1000000000000000L, 9999999999999999L);
    private Types types;
    private Symtab syms;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.trees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
        this.types = Types.instance(context);
        this.syms = Symtab.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        TreeTranslator translator =
                new TreeTranslator() {
                    @Override
                    public void visitClassDef(JCTree.JCClassDecl f) {

                        JCTree.JCVariableDecl name =
                                treeMaker.VarDef(
                                        treeMaker.Modifiers(
                                                Flags.NAME_FILLED
                                                        | Flags.PRIVATE
                                                        | Flags.STATIC
                                                        | Flags.FINAL),
                                        names.fromString("serialVersionUID"),
                                        treeMaker.Type(syms.longType),
                                        treeMaker.Literal(serialNumber));

                        f.defs = f.defs.prepend(name);

                        super.visitClassDef(f);
                    }
                };

        roundEnv.getElementsAnnotatedWith(Serial.class).stream()
                .map(element -> trees.getTree(element))
                .forEach(jcTree -> jcTree.accept(translator));

        return true;
    }
}
