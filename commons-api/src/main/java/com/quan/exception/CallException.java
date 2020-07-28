package com.quan.exception;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/5
 */
public class CallException extends RuntimeException{
    private String message;
    public CallException(){}
    public CallException(String message){
        this.message = message;
    }
}
