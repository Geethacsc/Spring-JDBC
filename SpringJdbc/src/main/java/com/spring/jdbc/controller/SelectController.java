package com.spring.jdbc.controller;

import com.spring.jdbc.dto.UserDTO;
import com.spring.jdbc.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <<<DIFFERENCE BETWEEN ROWMAPPER AND RESULTSETEXTRACTER>>>>
 *     Both RowMapper and ResultSetExtracter are used to fetch data from the ResultSet and map to dto or entity class
 *     RowMapper extracts data from ResultSet One Row at Time
 *     while ResultSetExtracter extracts all rows from ResultSet at a Time
 */
@RestController
@RequestMapping("/fetch")
public class SelectController {

    @Autowired
    private SelectService service;

    @GetMapping("/row-mapper")
    public ResponseEntity<List<UserDTO>> selectUsingRowMapper(@RequestParam String groupId){
        return new ResponseEntity<>(service.fetchUsingRowMapper(groupId), HttpStatus.OK);
    }

    @GetMapping("/result-set-extracter")
    public ResponseEntity<List<UserDTO>> selectUsingResultSetExtracter(@RequestParam String groupId){
        return new ResponseEntity<>(service.fetchUsingResultSet(groupId),HttpStatus.OK);
    }

    @GetMapping("/spring-bean-mapper")
    public ResponseEntity<List<UserDTO>> selectUsingSpringMapper(@RequestParam String groupId){
        return new ResponseEntity<>(service.fetchUsingBeanMapper(groupId),HttpStatus.OK);
    }


}
