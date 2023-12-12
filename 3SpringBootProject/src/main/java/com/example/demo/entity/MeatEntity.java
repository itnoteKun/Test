package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("meatsupply")

public class MeatEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String specie;
    private String number;
}