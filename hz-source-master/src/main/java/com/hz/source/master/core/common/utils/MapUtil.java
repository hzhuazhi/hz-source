package com.hz.source.master.core.common.utils;

import com.alibaba.fastjson.JSONArray;

import java.util.Map;

/**
 * @Description TODO
 * @Author long
 * @Date 2020/5/20 15:20
 * @Version 1.0
 */
public class MapUtil {
    /**
     * @Description: map 数据转json
     * @param resultMap
     * @return java.lang.String
     * @author long
     * @date 2020/5/20 15:22
     */
    public  static  String    mapToJson(Map<String,Object> resultMap){
        String str ="";
        try{
            JSONArray jArray = new JSONArray();
            jArray.add(resultMap);
            str = jArray.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
