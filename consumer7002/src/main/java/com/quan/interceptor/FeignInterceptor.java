package com.quan.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/6
 */
@Component
public class FeignInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {

        //通过RequestContextHolder获取本地请求
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        //获取本地线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        //给请求模板附加本地线程头部信息，主要是token信息
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement().toString();
            requestTemplate.header(name, request.getHeader(name));
        }

    }
}
