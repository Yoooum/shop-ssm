package com.prprv.ssm.service.impl;

import com.prprv.ssm.mapper.UserMapper;
import com.prprv.ssm.pojo.User;
import com.prprv.ssm.service.LoginService;
import com.prprv.ssm.utils.SqlSessionUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
@Log4j2
public class LoginServiceImpl implements LoginService {
    private User user;
    private final Map<String, Object> session = new HashMap<>();
    private final SqlSession sqlSession = SqlSessionUtil.getSession();
    private final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Override
    public Map<String, Object> getUser() {
        this.session.put("user", user);
        this.session.put("token", user.getEmail() + user.getPassword());
        return this.session;
    }

    /**
     * 关闭 SqlSession
     */
    @Override
    public void close() {
        sqlSession.close();
    }
    @Override
    public boolean login(String email, String password) {
        user = userMapper.selectUserByParam(email, password);
        return user != null;
    }

    @Override
    public User register(User user) {
        this.user = user;
        try {
            if(userMapper.insertUser(user) > 0){
                return this.user;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return this.user = null;
    }

}
