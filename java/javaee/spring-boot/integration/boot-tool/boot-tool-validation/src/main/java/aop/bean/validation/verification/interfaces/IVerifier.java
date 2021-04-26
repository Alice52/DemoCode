package aop.bean.validation.verification.interfaces;

import aop.bean.validation.verification.CustomException;

import java.lang.annotation.Annotation;

public interface IVerifier {

  public void validate(Object param, Annotation annotation, Annotation methodAnnotation)
      throws CustomException;
}
