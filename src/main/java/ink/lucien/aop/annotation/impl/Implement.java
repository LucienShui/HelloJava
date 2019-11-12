package ink.lucien.aop.annotation.impl;

import ink.lucien.aop.annotation.Logging;
import ink.lucien.aop.annotation.Timer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * Created by Lucien on 2019/10/21 12:33
 */
@Slf4j
@Aspect
@Component
public class Implement {

    @Around("@annotation(logging)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, Logging logging) throws Throwable {
        log.info("{} start, param = {}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
        Object result = proceedingJoinPoint.proceed();
        log.info("{} end, param = {}, result = {}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs(), result);
        return result;
    }

    @Around("@annotation(timer)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, Timer timer) throws Throwable {
        String clazzName = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object response = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Timer: [{}@{}] cost {} ms", clazzName, methodName, endTime - startTime);
        return response;
    }
}
