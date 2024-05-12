package com.project.loanservice.aop;

import com.project.loanservice.LoanServiceApplication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LogAspect {

    private static final Logger log =
            LoggerFactory.getLogger(LoanServiceApplication.class);

    @Around("execution(* com.project.loanservice.controller.impl.*.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) {
        try {
            log.info(
                    "[start][{}][{}]{}",
                    joinPoint.getSignature().getName(),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    Arrays.toString(joinPoint.getArgs())
            );

            Object result = joinPoint.proceed(joinPoint.getArgs());

            log.info(
                    "[end][{}][{}]{}",
                    joinPoint.getSignature().getName(),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    Arrays.toString(joinPoint.getArgs())
            );

            return result;

        } catch (Throwable e) {
            log.error(
                    "[error][{}][{}]",
                    joinPoint.getSignature().getName(),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    e
            );
            throw new RuntimeException(e);
        }

    }
}
