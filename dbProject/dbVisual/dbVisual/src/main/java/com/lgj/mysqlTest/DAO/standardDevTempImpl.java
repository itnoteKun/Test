package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.standardDevTempBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("standardDevTempImpl")
public class standardDevTempImpl implements standardDevTempDao{

    @Autowired  //使用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法诸如所需的外部资源
    private JdbcTemplate jdbcTemplate;  //jdbc连接工具类

    @Override
    public List<standardDevTempBean> findAll() {

        String sql = "select * from deltatemp order by standard_avetemp desc";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<standardDevTempBean>(standardDevTempBean.class));
    }
}
