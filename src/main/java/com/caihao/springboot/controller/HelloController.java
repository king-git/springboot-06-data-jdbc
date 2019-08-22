package com.caihao.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author CaiHao
 * @create 2019-08-07 下午 17:12:10
 */

@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @ResponseBody
    @RequestMapping("/query")
    public List<Map<String,Object>> map(){

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from dog ");
        System.err.println("list======"+list.toString());
        return list;
    }


    @ResponseBody
    @RequestMapping("/query2")
    public Map<String,Object> map2(){

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from dog where id = 2");
        System.err.println("list======"+list.toString());

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
