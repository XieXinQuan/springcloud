package com.quan.proxy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/7
 */
@Slf4j
public class CglibServiceProxy implements MethodInterceptor {
    /**
     * 代理Feign 调用Service方法
     */
    private Object target;

    /**
     * 定义获取代理对象方法
     */
    public Object getServiceProxy(Object targetClass){
        this.target = targetClass;
        Enhancer enhancer = new Enhancer();
        //设置父类,cglib生成的对象其实是代理对象的子类
        enhancer.setSuperclass(targetClass.getClass());
        //设置回调
        enhancer.setCallback(this);
        //创建代理对象
        Object result = enhancer.create();
        return result;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
        log.info("开始使用openfeign调用远程服务...");
        Object invoke = method.invoke(target, objects);
        if (invoke == null) {
            log.info("调用超时或者失败.");
        }
        log.info("调用完成.");
        return invoke;
    }



}
