package com.quan.aspect;

import com.quan.Enum.ResultEnum;
import com.quan.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/1/11
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Value("${server.port}")
    String localPort;

    /**
    切入点描述 这个是controller包的切入点
     */
    @Pointcut("execution(public * com.quan.controller..*.*(..))")
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称

    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        //这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        log.info("Request IP : {}", request.getRemoteAddr());
        log.info("Request Url : {}", request.getRequestURL().toString());
        log.info("Request Method Type: {}", request.getMethod());
        log.info("Request Parameter : {}", Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        log.info("Request Class : {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
    @AfterReturning(returning = "returnOb", pointcut = "controllerLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object returnOb) {
        log.info("Request Success Return Data : {}", returnOb);
    }
    @Around("controllerLog()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long endTime = System.currentTimeMillis();

        log.info("Total Time : {}ms.", (endTime - startTime));
        RestController annotation = pjp.getTarget().getClass().getAnnotation(RestController.class);
        if(annotation != null) {
            return new Result(ResultEnum.Success.getKey(), ResultEnum.Success.getValue(), proceed);
        }

        return proceed;

    }
}
