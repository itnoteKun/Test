package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.weatherNumBean;

import java.util.List;

public interface weatherNumDao {
    List<weatherNumBean> findByCity(String city);
}
