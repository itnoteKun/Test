package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.PricesEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PricesDao extends BaseMapper<PricesEntity> {
}