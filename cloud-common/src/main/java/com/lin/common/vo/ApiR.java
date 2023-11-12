package com.lin.common.vo;

import cn.hutool.core.date.DateUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * API 接口响应的类
 * @author chen.nan
 */
public class ApiR extends LinkedHashMap<String, Object> implements Serializable {

    /**
     * 旧服务 调用成功 状态码
     */
    public static Integer SUCCESS_OLD = 0;

    public static Integer SUCCESS = 200;
    public static Integer FAIL = 500;
    /**
     * 权限校验不通过
     */
    public static Integer INVALID = 5110;
    /**
     * 其他错误异常
     */
    public static Integer ERROR = 5101;
    public ApiR(){}

    /**
     * 正常响应
     */
    public static ApiR ok(){
        return  Objects.requireNonNull(Objects.requireNonNull(new ApiR()
                .put("code", SUCCESS))
                .put("message", "成功"))
                .put("data", "");
    }
    /**
     * 失败响应
     * @return R
     */
    public static ApiR fail(){
        HashMap<String, Object> hashMap = new HashMap<>(3);
        HashMap<String, Object> changeHashMap = new HashMap<>(3);
        hashMap.put("detail", changeHashMap);
        hashMap.put("releaseTime", DateUtil.now());
        hashMap.put("changeLog", "");
        return  Objects.requireNonNull(Objects.requireNonNull(new ApiR()
                .put("code", FAIL))
                .put("message", "系统繁忙,请稍后再试！"))
                .put("data", hashMap);
    }

    public ApiR code(Integer code){
        return this.put("code", code);
    }


    public ApiR message(String message){
        return this.put("message", message);
    }

    public ApiR data(Object data){
        return this.put("data", data);
    }

    /**
     * 判断响应结果是否成功
     * @param apiR 响应结果
     * @return true 成功 false 失败
     */
    public static boolean isSuccess(ApiR apiR){
        if (Objects.isNull(apiR)) {
            return Boolean.FALSE;
        }
        Object codeObject = apiR.get("code");
        if (Objects.isNull(codeObject)) {
            return Boolean.FALSE;
        }
        if (codeObject instanceof String) {
            String code = (String) codeObject;
            return SUCCESS_OLD.equals(Integer.valueOf(code));
        }
        if (codeObject instanceof Integer) {
            Integer code = (Integer) codeObject;
            return SUCCESS_OLD.equals(code);
        }
        return Boolean.FALSE;
    }

    /**
     * 获取返回响应结果 data 内容
     * @param apiR 响应结果
     * @return 结果 data 内容
     */
    public static Object getData(ApiR apiR){
        if (Objects.isNull(apiR)) {
            return null;
        }
        return apiR.get("data");
    }

    /**
     * 获取返回响应结果 message 内容
     * @param apiR 响应结果
     * @return 结果 message 内容
     */
    public static String getMessage(ApiR apiR){
        if (Objects.isNull(apiR)) {
            return "";
        }
        return (String) apiR.get("message");
    }

    @Override
    public ApiR put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
