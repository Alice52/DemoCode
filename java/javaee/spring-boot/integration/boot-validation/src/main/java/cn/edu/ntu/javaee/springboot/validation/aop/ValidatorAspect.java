package cn.edu.ntu.javaee.springboot.validation.aop;//package cn.edu.ntu.jsr303.aop;
//
//import cn.edu.ntu.jsr303.utils.ArgumentsValidatorUtil;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
///**
// * @author zack <br>
// * @create 2020-08-02 13:53 <br>
// * @project validation <br>
// */
//@Aspect
//@Component
//public class ValidatorAspect {
//
//  @Pointcut("execution (* cn.edu.ntu.jsr303.service.impl.*.*(..))")
//  public void allPrivateMethods() {}
//
//  @Before("allPrivateMethods()")
//  public void validateBefore(JoinPoint joinPoint) throws Exception {
//    Signature signature = joinPoint.getSignature();
//    MethodSignature mSignature = (MethodSignature) signature;
//    Object[] args = joinPoint.getArgs();
//
//    try {
////      ArgumentsValidatorUtil.validate(mSignature.getMethod(), args);
//    } catch (Exception exception) {
//      throw exception;
//    }
//  }
//}
