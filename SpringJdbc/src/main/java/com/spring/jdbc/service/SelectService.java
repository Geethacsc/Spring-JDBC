package com.spring.jdbc.service;

import com.spring.jdbc.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SelectService {

    List<UserDTO> fetchUsingRowMapper(String groupId);

    List<UserDTO> fetchUsingResultSet(String groupId);

    List<UserDTO> fetchUsingBeanMapper(String groupId);
}
