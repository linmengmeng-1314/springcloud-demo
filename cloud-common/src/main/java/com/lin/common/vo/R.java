package com.lin.common.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 页面响应的类
 * @author chen.nan
 */
public class R extends LinkedHashMap<String, Object> implements Serializable {

    public static Integer SUCCESS = 0;
    public static Integer FAIL = -1;
    public static Integer WARN = 1;

    public R(){}

    /**
     * 正常响应
     */
    public static R ok(){
        return  Objects.requireNonNull(Objects.requireNonNull(new R()
                .put("code", SUCCESS))
                .put("message", "成功"))
                .put("detail", "");
    }

    /**
     * 正常响应
     */
    public static <T> R ok(T data){
        return  Objects.requireNonNull(Objects.requireNonNull(new R()
                .put("code", SUCCESS))
                .put("message", "成功"))
                .put("data", data);
    }

    /**
     * 警告响应
     * @param message 警告信息
     * @return R
     */
    public static R warn(String message){
        return  Objects.requireNonNull(Objects.requireNonNull(new R()
                .put("code", WARN))
                .put("message", message))
                .put("detail", "");
    }

    /**
     * 失败响应
     * @return R
     */
    public static R fail(){
        return  Objects.requireNonNull(Objects.requireNonNull(new R()
                .put("code", FAIL))
                .put("message", "失败"))
                .put("detail", "");
    }

    public R code(Integer code){
        return this.put("code", code);
    }


    public R message(String message){
        return this.put("message", message);
    }

    public R detail(String detail){
        return this.put("detail", detail);
    }

    public <T> R addData(T data){
        if(data instanceof Page){
            @SuppressWarnings("rawtypes")
            Page page = (Page) data;
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("list", page.getRecords());
            map.put("pageNumber", page.getCurrent());
            map.put("pageSize", page.getSize());
            map.put("pageTotal", page.getPages());
            map.put("total", page.getTotal());
            return this.put("data", map);
        }else {
            return this.put("data", data);
        }
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
