package com.example.demo.mapper;


import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 数据访问层
 */
@Mapper
@Component
public interface AdminMapper {
    //    使用注解写sql查询语句
    @Select("SELECT * FROM `admin` where name=#{name}")
    public Admin findByName(String name);

    @Insert("INSERT into `admin`(name,pwd) values(#{name},#{pwd})")
    public void createAdmin(Admin admin);

    @Select("SELECT * FROM `admin` where name=#{name} and pwd=#{pwd}")
    Admin findByNameAndPwd(Admin admin);
}
