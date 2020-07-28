package com.quan.aspect;

import com.quan.Enum.ResultEnum;
import com.quan.entity.Result;
import com.quan.exception.CallException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/7
 */
@Aspect
@Component
@Slf4j
public class OpenFeignService {

    /**
     切入点描述 这个是controller包的切入点
     */
    @Pointcut("execution(public * com.quan.service..*.*(..))")
    public void serviceCutPoint(){}//签名，可以理解成这个切入点的一个名称

    @Before("serviceCutPoint()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        log.info("开始使用openfeign调用远程服务");
    }
    @AfterReturning(returning = "returnOb", pointcut = "serviceCutPoint()")
    public void doAfterReturning(JoinPoint joinPoint, Object returnOb) {
        log.info("远程服务返回数据: {}", returnOb);
    }
    @Around("serviceCutPoint()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        if (proceed == null){
            throw new CallException("系统繁忙");
        }
        if (proceed instanceof Result){
            Result result = (Result)proceed;
            if (!ResultEnum.Success.getKey().equals(result.getStatus())){
                throw new CallException(result.getMsg());
            }
        }
        long endTime = System.currentTimeMillis();

        log.info("远程调用耗时: {}ms.", (endTime - startTime));

        return proceed;

    }

}
