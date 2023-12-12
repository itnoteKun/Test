package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("cityNumberClean")

public class CityEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String city;
    private String cityShort;
    private String minPrice;
    private String maxPrice;
    private String num;
}