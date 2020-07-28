package com.quan.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/4
 */
public class CustomerBlockHandler {
    public static String handlerException(BlockException e){
//        throw new GlobalException(ResultEnum.CustomException.getKey(), "系统繁忙，请稍后重试。");
        return "系统繁忙";
    }
}
