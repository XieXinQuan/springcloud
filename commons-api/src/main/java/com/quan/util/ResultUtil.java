package com.quan.util;

import com.alibaba.fastjson.JSON;
import com.quan.Enum.ResultEnum;
import com.quan.entity.Result;

public class ResultUtil {
    public static String Success(Object data){ return JSON.toJSONString(new Result(ResultEnum.Success.getKey(), ResultEnum.Success.getValue(), data)); }
    public static String Success(){
        return Success(null);
    }

    public static String CustomException(Object data){ return ResultUtil.CustomException(ResultEnum.CustomException.getKey(), ResultEnum.CustomException.getValue(), data); }
//     自定义异常
    public static String CustomException(Integer status, String msg, Object data){ return JSON.toJSONString(new Result(status, msg, data)); }
    public static String CustomException(Integer status, String msg){ return ResultUtil.CustomException(status, msg, null);}
    public static String CustomException(String msg){ return ResultUtil.CustomException(ResultEnum.CustomException.getKey(), msg); }
    public static String CustomException(Integer status){
        return ResultUtil.CustomException(status, null);
    }
    public static String CustomException(){ return ResultUtil.CustomException(ResultEnum.CustomException.getKey(), ResultEnum.CustomException.getValue()); }
    public static String SystemException(String msg){return JSON.toJSONString(new Result(ResultEnum.SystemException.getKey(), ResultEnum.SystemException.getValue(), msg)); }
}
