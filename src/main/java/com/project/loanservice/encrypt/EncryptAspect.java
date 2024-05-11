package com.project.loanservice.encrypt;

import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Optional;

@Aspect
@Component
@RequiredArgsConstructor
public class EncryptAspect {

    private final EncryptComponent encryptComponent;

    @Pointcut("execution(* com.project.loanservice.repository.*Repository.save(..))")
    public void save() {}

    @Pointcut("execution(* com.project.loanservice.repository.*Repository.find*(..))")
    public void find() {}

    @Pointcut("execution(* com.project.loanservice.repository.*Repository.exist*(..))")
    public void search() {}

    @Before("save() && args(entity)")
    public void encryptData(Object entity) throws IllegalAccessException {
        for (Field field : entity.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Encrypt.class)) {
                field.setAccessible(true);
                String originalVal = (String) field.get(entity);
                String encryptedVal = encryptComponent.encryptString(originalVal);

                field.set(entity, encryptedVal);
            }
        }
    }

    @Around("find() || search()")
    public Object viewData(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            args[i] = encryptComponent.encryptString((String) args[i]);
        }
        return joinPoint.proceed(args);
    }

    @AfterReturning(pointcut = "find()", returning = "returnValue")
    public void decryptStringAfterReturning(Object returnValue) throws Throwable {

        Object entity = returnValue;

        if (entity instanceof Optional<?>) {
            Optional<?> optional = (Optional<?>) returnValue;
            entity = optional.orElseThrow(() ->
                    new CustomServiceException(ErrorCode.RETURNVALUE_INVALID));
        }

        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Encrypt.class)) {
                field.setAccessible(true);
                String encryptedVal = (String) field.get(entity);
                String originalVal = encryptComponent.decryptString(encryptedVal);

                field.set(entity, originalVal);
            }
        }
    }
}
