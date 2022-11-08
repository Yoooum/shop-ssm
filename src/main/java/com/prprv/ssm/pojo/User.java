package com.prprv.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 未確認の庭師
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String email;
    private String username;
    private String password;
    private Boolean admin;
}
