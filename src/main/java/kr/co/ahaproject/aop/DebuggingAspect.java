package kr.co.ahaproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DebuggingAspect {

    @Pointcut("execution(* kr.co.ahaproject.controller..*.*(..))")
    private void cut() {
    }

    @Before("cut()")
    public void loggingArgs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        String simpleName = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        String methodName = joinPoint.getSignature().getName();

        for (Object obj : args) {
            log.info("{}#{}의 입력값 => {}", simpleName, methodName, obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void loggingReturnValue(JoinPoint joinPoint, Object returnObj) {

        String simpleName = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        String methodName = joinPoint.getSignature().getName();

        log.info("{}#{}의 입력값 => {}", simpleName, methodName, returnObj);
    }
}
