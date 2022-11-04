package com.prprv.ssm.controller;

import com.alibaba.fastjson2.JSONObject;
import com.prprv.ssm.pojo.MsgBuilder;
import com.prprv.ssm.service.LoginService;
import com.prprv.ssm.service.impl.LoginServiceImpl;
import com.prprv.ssm.utils.RequestUtil;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 未確認の庭師
 */
@Log4j2
@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        LoginService service = new LoginServiceImpl();
        JSONObject data = RequestUtil.toJson(req);

        MsgBuilder msgBuilder;
        if (service.login(data.getString("email"), data.getString("password"))) {
            msgBuilder = new MsgBuilder(0, "登录成功", service.getUser());
            writer.print(msgBuilder.toJson());
        } else {
            msgBuilder = new MsgBuilder(1, "登录失败", null);
            writer.print(msgBuilder.toJson());
        }
        log.debug("发送响应: " + msgBuilder);
        service.close();
    }
}
