package com.cityWeather.weatherAvgWdLevel;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class avgWdLevelBean implements DBWritable, Writable {

    //字段
    private int id;
    private String province;
    private String city;
    private String year;
    private String month;
    private String day;
    private String week;
    private String tempMax;
    private String tempMin;
    private String weather;
    private String windDir;
    private String windLevel;
    private Integer tempAVG;
    private Integer avgWindLevel;

    //空参构造
    public avgWdLevelBean(){

    }

    //set与get方法
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getProvince(){
        return province;
    }

    public void setProvince(String province){
        this.province = province;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getTempAVG() {
        return tempAVG;
    }

    public void setTempAVG(Integer tempAVG) {
        this.tempAVG = tempAVG;
    }

    public String getTempMin() {
        return tempMin;
    }
    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindLevel() {
        return windLevel;
    }

    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel;
    }

    public Integer getAvgWindLevel() {
        return avgWindLevel;
    }

    public void setAvgWindLevel(Integer avgWindLevel) {
        this.avgWindLevel = avgWindLevel;
    }


    //数据库操作之写入
    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,weather);
        preparedStatement.setInt(2,avgWindLevel);


    }

    //数据库操作之读取
    @Override
    public void readFields(ResultSet resultSet) throws SQLException {
        //1,2,3对应列坐标，从1开始
        id = resultSet.getInt(1);
        province = resultSet.getString(2);
        city = resultSet.getString(3);
        year = resultSet.getString(4);
        month = resultSet.getString(5);
        day = resultSet.getString(6);
        week = resultSet.getString(7);
        tempMax = resultSet.getString(8);
        tempMin = resultSet.getString(9);
        weather = resultSet.getString(10);
        windDir = resultSet.getString(11);
        windLevel = resultSet.getString(12);
    }

    //序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeUTF(province);
        dataOutput.writeUTF(city);
        dataOutput.writeUTF(year);
        dataOutput.writeUTF(month);
        dataOutput.writeUTF(day);
        dataOutput.writeUTF(week);
        dataOutput.writeUTF(tempMax);
        dataOutput.writeUTF(tempMin);
        dataOutput.writeUTF(weather);
        dataOutput.writeUTF(windDir);
        dataOutput.writeUTF(windLevel);
    }

    //反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.province = dataInput.readUTF();
        this.city = dataInput.readUTF();
        this.year = dataInput.readUTF();
        this.month = dataInput.readUTF();
        this.day = dataInput.readUTF();
        this.week = dataInput.readUTF();
        this.tempMax = dataInput.readUTF();
        this.tempMin = dataInput.readUTF();
        this.weather = dataInput.readUTF();
        this.windDir = dataInput.readUTF();
        this.windLevel = dataInput.readUTF();
    }

}