package com.blackunion.george.plum.service.impl;

import com.blackunion.george.plum.pojo.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George on 2017-08-17.
 */
@Service
public class OrderServiceImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String findOrder(String orderId){
        String sql = "select * from sys_order where id = ?";
        RowMapper<OrderDTO> rowMapper = new BeanPropertyRowMapper<OrderDTO>(OrderDTO.class);
        List<OrderDTO> order = jdbcTemplate.query(sql, rowMapper,orderId);
        System.err.println(order.toString());
        return order.toString();
    }


}
