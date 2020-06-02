package com.quan.interceptor;

import com.quan.util.JwtUtil;
import com.quan.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/16
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter  {


        @Override
        public boolean preHandle(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object handler) throws SignatureException {
            /** 地址过滤 */
            String uri = request.getRequestURI() ;
            if (uri.contains("login") || uri.contains("error")){
                return true ;
            }
            /** Token 验证 */
            String token = request.getHeader(JwtUtil.header);
            if(StringUtils.isEmpty(token))
                token = request.getParameter(JwtUtil.header);

            if(StringUtils.isEmpty(token))
                throw new SignatureException("未登录或登录信息已过期");


            Claims claims = null;
            try{
                claims = JwtUtil.getTokenClaim(token);
                if(claims == null || JwtUtil.isTokenExpired(token)){
                    throw new SignatureException("请重新登录.");
                }
            }catch (Exception e){
                throw new SignatureException("请重新登录.");
            }

            return true;
        }
}
