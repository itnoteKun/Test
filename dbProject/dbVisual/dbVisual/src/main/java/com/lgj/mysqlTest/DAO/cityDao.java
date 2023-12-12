package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.cityBean;

import java.util.List;

public interface cityDao {
    List<cityBean> findall();
}
