package com.quan.advice;

import com.quan.Enum.ResultEnum;
import com.quan.exception.CallException;
import com.quan.exception.GlobalException;
import com.quan.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/1/11
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        String name = e.getClass().getName();
        log.error("There is a serious system exception, please deal with it...");
        log.error("Exception Start...");
        log.error("Exception Type : {}", e.getClass().getName());
        log.error("Exception Case: {}" , e.getMessage());
        log.error("Exception", e);
        log.error("Exception End...");
        return ResultUtil.CustomException("出现错误,请重试.");
    }
    @ExceptionHandler(value = GlobalException.class)
    public String exceptionHandler(GlobalException e){
        Integer status = e.getStatus() == null ? ResultEnum.CustomException.getKey() : e.getStatus();
        String msg = e.getMsg();
        if(msg == null){
            for(ResultEnum re : ResultEnum.values()){
                if(re.getKey().equals(status)) {
                    msg = re.getValue();
                    break;
                }
            }
        }
        log.info("Custom Exception Start");
        log.info(ResultUtil.CustomException(status, msg));
        log.info("Custom Exception End");
        return ResultUtil.CustomException(status, msg);
    }

    @ExceptionHandler(value = CallException.class)
    public String exceptionHandler(CallException e){
        log.info("Call Exception");
        return ResultUtil.CallException();
    }



}
