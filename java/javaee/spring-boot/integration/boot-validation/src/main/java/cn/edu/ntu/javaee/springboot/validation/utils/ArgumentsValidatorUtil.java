// package cn.edu.ntu.javaee.springboot.validation.utils;
//
// import cn.edu.ntu.jsr303.component.ValidatorUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.validation.annotation.Validated;
//
// import javax.validation.ConstraintViolation;
// import javax.validation.Validator;
// import java.lang.annotation.Annotation;
// import java.lang.reflect.Method;
// import java.util.Set;
//
/// **
// * @author zack <br/>
// * @create 2020-08-02 14:03 <br/>
// * @project validation <br/>
// */
// public final class ArgumentsValidatorUtil {
//
//    private static final Validator VALIDATOR = ValidatorUtils.getValidator();
//
//    public static void validate(Method method, Object[] args) throws Exception{
//        Annotation[][] paramsAnnotations = method.getParameterAnnotations();
////        Annotation[] methodAnotation = method.getAnnotations();
//        Annotation mAnnotation = null;
//
//
//        for (int iArg = 0; iArg < args.length; iArg++) {
//            Annotation[] curParamAnnotations = paramsAnnotations[iArg];
//            for (Annotation annotation : curParamAnnotations){
////                execValueValidator(args[iArg], annotation, mAnnotation);
//                Set<ConstraintViolation<Object>> validate = VALIDATOR.validate(args[iArg]);
//            }
//        }
//    }
// }
