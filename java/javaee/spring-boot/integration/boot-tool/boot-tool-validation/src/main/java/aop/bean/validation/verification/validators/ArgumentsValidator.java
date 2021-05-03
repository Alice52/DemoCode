package aop.bean.validation.verification.validators;

import aop.bean.validation.verification.CustomException;
import aop.bean.validation.verification.annotations.CheckObject;
import aop.bean.validation.verification.annotations.CheckRegexp;
import aop.bean.validation.verification.annotations.Validated;
import aop.bean.validation.verification.interfaces.IVerifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ArgumentsValidator {

    private static Map<Class<?>, Class<? extends IVerifier>> verifiersMap = null;

    static {
        verifiersMap = new HashMap<Class<?>, Class<? extends IVerifier>>();
        verifiersMap.put(CheckRegexp.class, RegExpValidator.class);
        verifiersMap.put(CheckObject.class, ObjectValidator.class);
    }

    public static Map<Class<?>, Class<? extends IVerifier>> getVerifiersMap() {
        return verifiersMap;
    }

    public static void validate(Method method, Object[] args) throws CustomException {
        Annotation[][] paramsAnnotations = method.getParameterAnnotations();
        Annotation[] methodAnotation = method.getAnnotations();
        Annotation mAnnotation = null;

        for (Annotation annotation : methodAnotation) {
            if (annotation.annotationType() == Validated.class) {
                mAnnotation = annotation;
                break;
            }
        }

        for (int iArg = 0; iArg < args.length; iArg++) {
            Annotation[] curParamAnnotations = paramsAnnotations[iArg];
            for (Annotation annotation : curParamAnnotations) {
                execValueValidator(args[iArg], annotation, mAnnotation);
            }
        }
    }

    private static void execValueValidator(
            Object value, Annotation annotation, Annotation methodAnnotation)
            throws CustomException {
        try {
            Class<? extends IVerifier> verifierClass =
                    verifiersMap.get(annotation.annotationType());

            if (verifierClass != null) {
                IVerifier curVerifier = verifierClass.newInstance();
                curVerifier.validate(value, annotation, methodAnnotation);
            }
        } catch (IllegalAccessException exception) {
            exception.printStackTrace();
        } catch (InstantiationException exception) {
            exception.printStackTrace();
        } catch (CustomException exception) {
            throw exception;
        }
    }
}
