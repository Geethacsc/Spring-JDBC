package com.spring.jdbc.service;

import com.spring.jdbc.dto.UserDTO;
import com.spring.jdbc.mapper.UserResultSetExtracter;
import com.spring.jdbc.mapper.UserRowMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SelectServiceImpl implements  SelectService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String sql="select id,user_id,password from user_Info where group_id=?";

    @Override
    public List<UserDTO> fetchUsingRowMapper(String groupId) {
        return jdbcTemplate.query(sql, new UserRowMapper(),groupId);
    }

    @Override
    public List<UserDTO> fetchUsingResultSet(String groupId) {
        return jdbcTemplate.query(sql,new UserResultSetExtracter(),groupId);
    }

    @Override
    public List<UserDTO> fetchUsingBeanMapper(String groupId) {

        //BeanPropertyRowMapper is auto mapper class in spring framework
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class),groupId);
    }
}
