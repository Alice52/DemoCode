package aop.bean.validation.verification.validators;

import aop.bean.validation.verification.CustomException;
import aop.bean.validation.verification.interfaces.IVerifier;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

public class ObjectValidator implements IVerifier {

    @Override
    public void validate(Object param, Annotation annotation, Annotation methodAnnotation)
            throws CustomException {
        Class<?> beanClass = param.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        Map<Class<?>, Class<? extends IVerifier>> verifiersMap =
                ArgumentsValidator.getVerifiersMap();

        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();
            for (Annotation fieldAnnotation : fieldAnnotations) {
                if (verifiersMap.containsKey(fieldAnnotation.annotationType())) {
                    Class<? extends IVerifier> verifierClass =
                            verifiersMap.get(fieldAnnotation.annotationType());
                    IVerifier verifier = null;

                    try {
                        verifier = verifierClass.newInstance();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        throw new CustomException("", "can't create varifier instance");
                    }

                    Object value = null;

                    try {
                        value =
                                new PropertyDescriptor(field.getName(), beanClass)
                                        .getReadMethod()
                                        .invoke(param);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        throw new CustomException("", "can't create property descriptor");
                    }

                    verifier.validate(value, fieldAnnotation, methodAnnotation);
                }
            }
        }
    }
}
