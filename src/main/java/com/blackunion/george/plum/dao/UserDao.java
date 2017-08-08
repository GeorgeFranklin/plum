package com.blackunion.george.plum.dao;

import com.blackunion.george.plum.pojo.dto.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by George on 2017-08-08.
 */
public interface UserDao {

    /**
     * 根据用户名获取单个用户。
     * @param userName
     * @return
     * @throws SQLException
     */
    User getUser(String userName) throws SQLException;

    /**
     * 获取多个用户
     * @return
     * @throws SQLException
     */
    List<User> listUser() throws SQLException;

    void saveUser() throws SQLException;

    void removeUser() throws SQLException;

    void updateUSer() throws SQLException;
}
