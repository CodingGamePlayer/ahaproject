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
    //aop 기능 추가 1
    @Pointcut("execution(* kr.co.ahaproject.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("execution(* kr.co.ahaproject.service..*.*(..))")
    private void cut1(){
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

    @Before("cut1()")
    public void loggingArgsForServ(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        String simpleName = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        String methodName = joinPoint.getSignature().getName();

        for (Object obj : args) {
            log.info("{}#{}의 입력값 => {}", simpleName, methodName, obj);
        }
    }

    @AfterReturning(value = "cut1()", returning = "returnObj")
    public void loggingReturnValueForServ(JoinPoint joinPoint, Object returnObj) {

        String simpleName = joinPoint.getTarget()
                .getClass()
                .getSimpleName();

        String methodName = joinPoint.getSignature().getName();

        log.info("{}#{}의 입력값 => {}", simpleName, methodName, returnObj);
    }
}
