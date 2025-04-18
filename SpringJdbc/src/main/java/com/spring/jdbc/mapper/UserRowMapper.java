package com.spring.jdbc.mapper;

import com.spring.jdbc.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRowMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("inside UserRowMapper>>>>");

        UserDTO user=new UserDTO();
        user.setId(rs.getLong("id"));
        user.setUserId(rs.getString("user_id"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
