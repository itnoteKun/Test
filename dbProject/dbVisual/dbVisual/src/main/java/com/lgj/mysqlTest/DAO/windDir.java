package com.lgj.mysqlTest.DAO;

import com.lgj.mysqlTest.Bean.windDirBean;

import java.util.List;

public interface windDir {
    List<windDirBean> findData(String province);
}
