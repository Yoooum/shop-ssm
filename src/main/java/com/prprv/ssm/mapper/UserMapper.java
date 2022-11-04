package com.prprv.ssm.mapper;

import com.prprv.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 未確認の庭師
 */
public interface UserMapper {
    int insertUser(User user);
    int updateUser(User user);
    int deleteUserById(Integer uid);
    User selectUserById(Integer uid);
    User selectUserByEmail(String email);
    User selectUserByName(String username);
    User selectUserByParam(
            @Param("email") String email,
            @Param("password") String password
    );
    List<User> selectAllUser();
}
