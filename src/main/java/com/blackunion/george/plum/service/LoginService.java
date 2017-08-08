package com.blackunion.george.plum.service;

import com.blackunion.george.plum.pojo.dto.User;

import java.sql.SQLException;

/**
 * 账户登陆业务处理。
 * Created by George on 2017-08-08.
 */
public interface LoginService {

    /**
     * 用户账户登陆。
     * @param userName 用户账户名称
     * @return User 返回查询到的用户信息，若用户不存在，则返回null
     * @throws SQLException 数据库操作失败
     */
    User login(String userName) throws SQLException;
}
