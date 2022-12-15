package cn.edu.ntu.java.processor;

import cn.edu.ntu.java.annotations.SeDataV2;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import java.lang.annotation.Annotation;

/**
 * @author zack <br>
 * @create 2022-12-14 00:28 <br>
 * @project javas-jhm <br>
 */
@SupportedAnnotationTypes("cn.edu.ntu.java.annotations.SeDataV2")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DataProcessorV2 extends BaseProcessor {

    @Override
    protected Class<? extends Annotation> anno() {
        return SeDataV2.class;
    }

    @Override
    protected void initCustom() {
        c.add(this::addGetterMethod);
        c.add(this::addSetterMethod);
    }

    /**
     * 创建get方法
     *
     * @param jcVariableDecl
     * @return
     */
    private JCTree.JCMethodDecl addGetterMethod(JCTree.JCVariableDecl jcVariableDecl) {
        // 方法的访问级别
        JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PUBLIC);
        // 方法名称
        Name methodName = getMethodName(jcVariableDecl.getName());
        // 设置返回值类型
        JCTree.JCExpression returnMethodType = jcVariableDecl.vartype;
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        statements.append(
                treeMaker.Return(
                        treeMaker.Select(
                                treeMaker.Ident(names.fromString("this")),
                                jcVariableDecl.getName())));
        // 设置方法体
        JCTree.JCBlock methodBody = treeMaker.Block(0, statements.toList());
        List<JCTree.JCTypeParameter> methodGenericParams = List.nil();
        List<JCTree.JCVariableDecl> parameters = List.nil();
        List<JCTree.JCExpression> throwsClauses = List.nil();

        // 构建方法
        return treeMaker.MethodDef(
                modifiers,
                methodName,
                returnMethodType,
                methodGenericParams,
                parameters,
                throwsClauses,
                methodBody,
                null);
    }

    /**
     * 创建set方法
     *
     * @param jcVariableDecl
     * @return
     */
    private JCTree.JCMethodDecl addSetterMethod(JCTree.JCVariableDecl jcVariableDecl) {
        try {
            // 方法的访问级别
            JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PUBLIC);
            // 定义方法名
            Name methodName = setMethodName(jcVariableDecl.getName());
            // 定义返回值类型
            JCTree.JCExpression returnMethodType =
                    treeMaker.Type(
                            (Type)
                                    (Class.forName("com.sun.tools.javac.code.Type$JCVoidType")
                                            .newInstance()));
            ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
            statements.append(
                    treeMaker.Exec(
                            treeMaker.Assign(
                                    treeMaker.Select(
                                            treeMaker.Ident(names.fromString("this")),
                                            jcVariableDecl.getName()),
                                    treeMaker.Ident(jcVariableDecl.getName()))));
            // 定义方法体
            JCTree.JCBlock methodBody = treeMaker.Block(0, statements.toList());
            List<JCTree.JCTypeParameter> methodGenericParams = List.nil();
            // 定义入参
            JCTree.JCVariableDecl param =
                    treeMaker.VarDef(
                            treeMaker.Modifiers(Flags.PARAMETER, List.nil()),
                            jcVariableDecl.name,
                            jcVariableDecl.vartype,
                            null);
            // 设置入参
            List<JCTree.JCVariableDecl> parameters = List.of(param);
            List<JCTree.JCExpression> throwsClauses = List.nil();
            // 构建新方法
            return treeMaker.MethodDef(
                    modifiers,
                    methodName,
                    returnMethodType,
                    methodGenericParams,
                    parameters,
                    throwsClauses,
                    methodBody,
                    null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Name getMethodName(Name name) {
        String s = name.toString();
        return names.fromString(
                "get" + s.substring(0, 1).toUpperCase() + s.substring(1, name.length()));
    }

    private Name setMethodName(Name name) {
        String s = name.toString();
        return names.fromString(
                "set" + s.substring(0, 1).toUpperCase() + s.substring(1, name.length()));
    }
}
