package com.prprv.ssm.service;

import com.prprv.ssm.mapper.UserMapper;
import com.prprv.ssm.pojo.User;

import java.util.Map;

/**
 * @author 未確認の庭師
 */
public interface LoginService {
    void close();
    Map<String,Object> getUser();
    boolean login(String email, String password);
    User register(User user);
}
