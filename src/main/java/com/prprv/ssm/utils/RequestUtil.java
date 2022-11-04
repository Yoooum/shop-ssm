package com.prprv.ssm.utils;

import com.alibaba.fastjson2.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * @author 未確認の庭師
 */
public class RequestUtil {
    public static JSONObject toJson(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader;
        try {
            reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(builder.toString());
    }
}
