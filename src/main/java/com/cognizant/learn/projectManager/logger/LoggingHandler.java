package com.cognizant.learn.projectManager.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
public class LoggingHandler {

    Logger log = LoggerFactory.getLogger(this.getClass());

   /* @Pointcut("within(@com.cognizant.learn.projectManager.controller *)")
    public void controller() {
    }

    @Pointcut("execution(* *.*(..))")
    protected void allMethod() {
    }

    @Pointcut("execution(public * *(..))")
    protected void loggingPublicOperation() {
    }

    @Pointcut("execution(* *.*(..))")
    protected void loggingAllOperation() {
    }

    @Pointcut("within(org.learn.log..*)")
    private void logAnyFunctionWithinResource() {
    }

    //before -> Any resource annotated with @Controller annotation
    //and all method and function taking HttpServletRequest as first parameter
    @Before("controller() && allMethod() && args(..,request)")
    public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {

        log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
        log.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        log.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
        log.debug("Target class : " + joinPoint.getTarget().getClass().getName());

        if (null != request) {
            log.debug("Start Header Section of request ");
            log.debug("Method Type : " + request.getMethod());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = (String) headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                log.debug("Header Name: " + headerName + " Header Value : " + headerValue);
            }
            log.debug("Request Path info :" + request.getServletPath());
            log.debug("End Header Section of request ");
        }
    }

    //After -> Any method within resource annotated with @Controller annotation
    // throws an exception ...Log it
    @AfterThrowing(pointcut = "controller() && allMethod()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
        log.error("Cause : " + exception.getCause());
    }
    //Around -> Any method within resource annotated with @Controller annotation
    @Around("controller() && allMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        try {
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            log.debug("Method " + className + "." + methodName + " ()" + " execution time : "
                    + elapsedTime + " ms");

            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
                    + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }*/

}
