package ink.lucien.aop.annotation.impl;

import ink.lucien.aop.annotation.Permission;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lucien on 2019/10/21 12:33
 */
@Slf4j
public class PermissionApp {

    private List<String> allowedString = Arrays.asList("Hello", "World");

    @Around("@annotation(permission)")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint, Permission permission) throws Throwable {
        // 获取 annotation 中的参数
        String value = permission.value();
        if (!allowedString.contains(value)) {
            return null;
        }

        String methodName = proceedingJoinPoint.getSignature().getName();

        log.info("{} start, param = {}", methodName, proceedingJoinPoint.getArgs());
        Object result = proceedingJoinPoint.proceed();
        log.info("{} end, param = {}, result = {}", methodName, proceedingJoinPoint.getArgs(), result);
        return result;
    }
}
