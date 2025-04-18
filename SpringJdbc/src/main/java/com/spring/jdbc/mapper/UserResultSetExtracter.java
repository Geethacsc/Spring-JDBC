package com.spring.jdbc.mapper;

import com.spring.jdbc.dto.UserDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultSetExtracter implements ResultSetExtractor<List<UserDTO>> {

    @Override
    public List<UserDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {

        System.out.println("Inside ResultSetExtracter>>>>");
        List<UserDTO> userList=new ArrayList<>();

        while(rs.next()){
            UserDTO user=new UserDTO();
            user.setId(rs.getLong("id"));
            user.setUserId(rs.getString("user_id"));
            user.setPassword(rs.getString("password"));
            userList.add(user);
        }
        return userList;
    }
}
