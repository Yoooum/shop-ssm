package com.prprv.ssm.pojo;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 未確認の庭師
 */
@Data
@AllArgsConstructor
public class MsgBuilder {
    private Integer code;
    private String msg;
    private Object data;

    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        obj.put("code", this.code);
        obj.put("msg", this.msg);
        obj.put("data", this.data);
        return obj;
    }
}
