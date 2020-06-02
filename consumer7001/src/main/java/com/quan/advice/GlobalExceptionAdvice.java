package com.quan.advice;

import com.quan.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/1/11
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        String name = e.getClass().getName();
        logger.error("There is a serious system exception, please deal with it...");
        logger.error("Exception Start...");
        logger.error("Exception Type : {}", e.getClass().getName());
        logger.error("Exception Case: {}" , e.getMessage());
        logger.error("Exception", e);
        logger.error("Exception End...");
        return ResultUtil.CustomException("出现错误,请重试.");
    }


}
