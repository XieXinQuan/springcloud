package com.quan.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/7
 */
@Slf4j
public class JDKServiceProxy implements InvocationHandler  {
    private Object target;

    public Object newProxyInstance(Object targetClass){
        this.target = targetClass;

        return Proxy.newProxyInstance(targetClass.getClass().getClassLoader(),
                targetClass.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        log.info("开始使用openfeign调用远程服务");
        Object invoke = method.invoke(target, args);
        log.info("调用完成.");
        return invoke;
    }

    public static void main(String[] args) {

    }
}
