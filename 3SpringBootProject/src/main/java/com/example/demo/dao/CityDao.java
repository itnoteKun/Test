package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.CityEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityDao extends BaseMapper<CityEntity> {
}