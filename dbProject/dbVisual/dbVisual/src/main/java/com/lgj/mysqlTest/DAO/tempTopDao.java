package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.tempTopBean;

import java.util.List;

public interface tempTopDao {
    List<tempTopBean> findTop();
}
