package aop.bean.validation.verification.validators;

import aop.bean.validation.verification.CustomException;
import aop.bean.validation.verification.ValidationPolicy;
import aop.bean.validation.verification.annotations.CheckRegexp;
import aop.bean.validation.verification.annotations.Validated;
import aop.bean.validation.verification.interfaces.IVerifier;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpValidator implements IVerifier {

    @Override
    public void validate(Object param, Annotation annotation, Annotation methodAnnotation)
            throws CustomException {
        CheckRegexp regexpAnnotation = (CheckRegexp) annotation;
        ValidationPolicy policy;

        if (methodAnnotation != null) {
            policy = ((Validated) methodAnnotation).policy();
        } else {
            policy = ValidationPolicy.ADD;
        }

        for (int i = 0; i < regexpAnnotation.policy().length; i++) {
            if (policy.equals(regexpAnnotation.policy()[i])) {
                Pattern pattern = Pattern.compile(regexpAnnotation.expression());
                Matcher matcher = pattern.matcher((String) param);

                if (!matcher.matches()) {
                    throw new CustomException(
                            regexpAnnotation.messageRef(), "regexp validation error");
                }

                break;
            }
        }
    }
}
