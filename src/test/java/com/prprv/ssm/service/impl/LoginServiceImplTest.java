package com.prprv.ssm.service.impl;

import com.prprv.ssm.pojo.MsgBuilder;
import com.prprv.ssm.pojo.User;
import com.prprv.ssm.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


/**
 * @author 未確認の庭師
 */
@Log4j2
class LoginServiceImplTest {
    //日志
    private static final Logger logger = LogManager.getLogger(LoginServiceImplTest.class);
    @Test
    void login() {
        LoginService service = new LoginServiceImpl();
        boolean isLogin = service.login("123@123.com", "123456");
        if (isLogin) {
            log.info(new MsgBuilder(0, "登录成功", service.getUser()).toJson());
        } else {
            log.info(new MsgBuilder(1, "登录失败", null).toJson());
        }
        service.close();
    }

    @Test
    void register() {
        LoginService service = new LoginServiceImpl();
        User user = new User();
        user.setEmail("456@456.com");
        user.setUsername("456");
        user.setPassword("456456");

        User reg = service.register(user);
        if (reg != null) {
            log.info(new MsgBuilder(0, "注册成功", reg).toJson());
        } else {
            log.info(new MsgBuilder(1, "注册失败", null));
        }
        service.close();
    }
}