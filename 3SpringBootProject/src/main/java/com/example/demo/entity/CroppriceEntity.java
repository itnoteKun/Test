package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("dynamic")

public class CroppriceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String date;
    private String avgPrice;

}