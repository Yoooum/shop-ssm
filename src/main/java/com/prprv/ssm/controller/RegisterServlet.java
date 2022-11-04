package com.prprv.ssm.controller;

import com.alibaba.fastjson2.JSONObject;
import com.prprv.ssm.pojo.MsgBuilder;
import com.prprv.ssm.pojo.User;
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
@WebServlet(name = "RegisterServlet", urlPatterns = "/api/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        LoginService service = new LoginServiceImpl();
        JSONObject data = RequestUtil.toJson(req);

        User user = new User();
        user.setEmail(data.getString("email"));
        user.setUsername(data.getString("username"));
        user.setPassword(data.getString("password"));
        user.setAdmin(false);

        MsgBuilder msgBuilder;
        User reg = service.register(user);
        if (reg != null) {
            msgBuilder = new MsgBuilder(0, "注册成功", reg);
            writer.print(msgBuilder.toJson());
        } else {
            msgBuilder = new MsgBuilder(1, "注册失败", null);
            writer.print(msgBuilder.toJson());
        }
        log.debug("发送响应: " + msgBuilder);
    }
}
