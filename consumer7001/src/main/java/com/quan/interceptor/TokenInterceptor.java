package com.quan.interceptor;

import com.quan.Enum.ResultEnum;
import com.quan.annotation.NeedLogin;
import com.quan.exception.GlobalException;
import com.quan.util.JwtUtil;
import com.quan.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/16
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException {
        //没有@NeedLogin注解，直接通过
//        if ()
        if (!(handler instanceof HandlerMethod))return true;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();

        if (!method.isAnnotationPresent(NeedLogin.class) && !declaringClass.isAnnotationPresent(NeedLogin.class)) return true;
        NeedLogin annotation = method.getAnnotation(NeedLogin.class);
        String tips = annotation.message();
        /** Token 验证 */
        String token = request.getHeader(JwtUtil.header);
        if(StringUtils.isEmpty(token))
            token = request.getParameter(JwtUtil.header);


        if(StringUtils.isEmpty(token))
            throw new GlobalException(ResultEnum.CustomException.getKey(), tips);


        Claims claims = null;
        try{
            claims = JwtUtil.getTokenClaim(token);
            if(claims == null || JwtUtil.isTokenExpired(token)){
                throw new GlobalException(ResultEnum.CustomException.getKey(), tips);
            }
        }catch (Exception e){
            throw new GlobalException(ResultEnum.CustomException.getKey(), tips);
        }

        return true;
    }
}
