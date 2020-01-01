package com.wc.project.fruitshop.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * errorCode 是0:成功
 * errorCode 是-1:失败
 */
public class ResponseUtil {
    /**
     * 不带参方法,默认errorCode为-1
     * @return
     */
    public static Object fail(){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errorCode","-1");
        obj.put("errorMsg","运行出错!");
        return obj;
    }

    /**
     * 带参方法
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static Object fail(int errorCode,String errorMsg){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errorCode",errorCode);
        obj.put("errorMsg",errorMsg);
        return obj;
    }

    /**
     * 不接受数据
     * @return
     */
    public static Object success(){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errorCode","0");
        obj.put("erreorMsg","成功!");
        return obj;
    }

    /**
     * 只接收数据
     * @param data
     * @return
     */
    public static Object success(Object data){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errorCode","0");
        obj.put("erreorMsg","成功!");
        obj.put("data",data);
        return obj;
    }

    /**
     * 接收信息和数据
     * @param erreorMsg
     * @param data
     * @return
     */
    public static Object success(String erreorMsg,Object data){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errorCode","0");
        obj.put("erreorMsg",erreorMsg);
        obj.put("data",data);
        return obj;
    }

    /**
     * 错误代码
     * @return
     */
    public static Object incorrectParam(){
        return fail(401,"参数不正确!");
    }
}
