package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class LogAop {

    @Pointcut("execution(* com.itheima.dao.BookDaoInterface.*(..))")
    private void log() {
    }

    @Before(value = "log()")
    public void logBeforeAction() {
        log.info("before aop--------------------------");
    }

    @After(value = "log()")
    public void logAfterAction() {
        log.info("after aop--------------------------");
    }

    //  returning = "result"实现通过参数result捕获以上拦截方法的返回内容，pointcut = "log()"是取得切面
    @AfterReturning(returning = "result", pointcut = "log()")
    public void logAfterReturningAction(Object result) {
        log.info("after returning aop-------------------------");

    }

    @Around(value = "log()")
    public Object logAroundAction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around aop--------------------------");
        // 获取方法参数数组
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("method parameters are: ", args);

        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        // 获取方法名
        String methodName = methodSignature.getName();

        Method method = methodSignature.getMethod();
        String[] parameterNames = methodSignature.getParameterNames();
        Class[] parameterTypes = methodSignature.getParameterTypes();

        Object result = proceedingJoinPoint.proceed(args);
        log.info("run result is " + result);
        return result;


    }

}
