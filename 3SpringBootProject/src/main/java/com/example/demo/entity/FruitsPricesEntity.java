package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("fruitscleanprice")

public class FruitsPricesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String fruitsName;
    private String fruitsMinPrice;
    private String fruitsMaxPrice;
    private String fruitsAvgPrice;
}