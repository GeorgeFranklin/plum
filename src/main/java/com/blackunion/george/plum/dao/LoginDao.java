package com.blackunion.george.plum.dao;

import com.blackunion.george.plum.pojo.dto.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * 用户账户登陆持久层。
 * Created by George on 2017-08-08.
 */
@Repository
public interface LoginDao {

    /**
     * 用户账户登陆。
     * @param userName 用户账户登陆名。
     * @return User 返回根据用户名查询到的用户信息。
     * @throws SQLException 数据库操作异常。
     * @since V1.0.0
     */
    User login(String userName) throws SQLException;
}
