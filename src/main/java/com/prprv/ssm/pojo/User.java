package com.prprv.ssm.pojo;

import lombok.Data;

/**
 * @author 未確認の庭師
 */
@Data
public class User {
    private Integer uid;
    private String email;
    private String username;
    private String password;
    private Boolean admin;
}
