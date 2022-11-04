package com.prprv.ssm.mapper;

import com.prprv.ssm.pojo.User;
import com.prprv.ssm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


/**
 * @author 未確認の庭師
 */
class UserMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @AfterEach
    void after(){
        System.out.println("sqlSession close");
        sqlSession.close();
    }
    @Test
    void insertUser() {
        User user = new User();
        user.setEmail("123@123.com");
        user.setUsername("123");
        user.setPassword("123456");
        user.setAdmin(false);
        userMapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setUid(22);
        user.setEmail("123@123.com");
        user.setUsername("1234");
        user.setPassword("123456");
        user.setAdmin(false);
        userMapper.updateUser(user);
        System.out.println(user);
    }

    @Test
    void deleteUser() {
        System.out.println(userMapper.deleteUserById(22));
    }

    @Test
    void selectUserById() {
        System.out.println(userMapper.selectUserById(22));
    }

    @Test
    void selectUserByEmail() {
        System.out.println(userMapper.selectUserByEmail("123@123.com"));
    }

    @Test
    void selectUserByName() {
        System.out.println(userMapper.selectUserByName("1234"));
    }

    @Test
    void checkLogin() {
        System.out.println(userMapper.selectUserByParam("123@123.com", "123456"));
    }





    @Test
    void selectAllUser() {
        userMapper.selectAllUser().forEach(System.out::println);
    }
}