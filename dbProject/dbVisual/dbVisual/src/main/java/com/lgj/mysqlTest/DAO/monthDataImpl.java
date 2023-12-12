package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.monthBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("monthDataImpl")
public class monthDataImpl implements monthDataDao{

    @Autowired  //使用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法诸如所需的外部资源
    private JdbcTemplate jdbcTemplate;  //jdbc连接工具类

    @Override
    public List<monthBean> findMonthData(String province) {
        String sql = "select * from monthData where province=\"" + province + "\"";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<monthBean>(monthBean.class));
    }
}
