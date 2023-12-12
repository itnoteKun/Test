package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.tempTopBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tempTopImpl")
public class tempTopImpl implements tempTopDao{

    @Autowired  //使用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法诸如所需的外部资源
    private JdbcTemplate jdbcTemplate;  //jdbc连接工具类

    @Override
    public List<tempTopBean> findTop() {
        String sql = "select * from tempAverage order by tempAverage desc";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<tempTopBean>(tempTopBean.class));
    }
}
