package com.example.demo.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class AspectDemo {

    @Before("execution(* com.example.demo.service.impl.CalculationServiceImpl.findMaX(..))")
    public void BeforeFindMaxAdvice(JoinPoint joinPoint){
        log.info("Executing Before Advice on findMax() : "+ joinPoint);
    }

    @After("execution(* com.example.demo.service.impl.CalculationServiceImpl.findMaX(..))")
    public void AfterFindMaxAdvice(JoinPoint joinPoint){
        log.info("Executing After Advice on findMax() : "+ joinPoint);
    }

    @After("findMaxPointcut()")
    public void AfterPointCutFindMaxAdvice(JoinPoint joinPoint){
        log.info("Executing AfterPointCut Advice on findMax() : "+ joinPoint);
    }

    @After("findMaxPointcut()")
    public void BeforePointCutFindMaxAdvice(JoinPoint joinPoint){
        log.info("Executing BeforePointCut Advice on findMax() : "+ joinPoint.toString());
    }

    @Pointcut("execution(* com.example.demo.service.impl.CalculationServiceImpl.findMaX(..))")
    public void findMaxPointcut(){}

    @Pointcut("execution(* com.example.demo.service.impl.CalculationServiceImpl.throwException(..))")
    public void exceptionPointcut(){}

    @Pointcut("@annotation(com.example.demo.Aspect.CustomAnnotation)")
    public void CustomAnnotationPointcut(){}

    @AfterThrowing("exceptionPointcut()")
    public void afterThrowingExceptions(JoinPoint joinPoint){
        log.info("Exception thrown : "+joinPoint.toString());
    }

    @AfterReturning(pointcut = "findMaxPointcut()", returning="result")
    public void afterReturningFindMax(Object result){
        log.info("Find Max After Returning : " +result.toString());
    }

    @AfterReturning("CustomAnnotationPointcut()")
    public void customAnnotationAdvice(JoinPoint joinPoint){
        log.info("customAnnotation Advice : " +joinPoint.toString());
    }

    @Around("findMaxPointcut()")
    public void aroundFindMax(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Before Processing FindMax : " + proceedingJoinPoint);
        Object value = proceedingJoinPoint.proceed();
        log.info("After Processing FindMax : " + value.toString());

    }

}
