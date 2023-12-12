package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.monthBean;

import java.util.List;

public interface monthDataDao {
    List<monthBean> findMonthData(String province);
}
