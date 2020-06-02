package com.quan.service;

import com.quan.dao.UserRepository;
import com.quan.entity.User;
import com.quan.util.JwtUtil;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/16
 */
public class BaseService {
    @Resource
    UserRepository userRepository;

    HttpServletRequest request;

    public Long getCurrentUserId(){

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        this.request = request;
        if (!checkIsLogin()) return 0L;


        String token = request.getHeader(JwtUtil.header);
        String subject = JwtUtil.getSubjectFromToken(token);

        return Long.parseLong(subject);
    }
    private boolean checkIsLogin(){
        if (request == null || request.getHeader(JwtUtil.header) == null) return false;
        String token = request.getHeader(JwtUtil.header);
        return !JwtUtil.isTokenExpired(token);
    }
    public User getCurrentUser(){
        Long currentUserId = getCurrentUserId();

        User user = userRepository.findById(currentUserId).get();

        return user;
    }
}
