package com.bigdata1901.prices;


import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 1.实现 DBWritable, Writable
public class MyDBWritable implements DBWritable, Writable {
    // 数据库的写入字段
    private int id;
    private String date;
    private String variety;
    private String min_price;
    private String max_price;
    private String avg_price;

    // 写出字段
    // 2.反序列化所需要的空参构造
    public MyDBWritable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getMin_price() { return min_price; }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() { return max_price; }

    public void setMax_price(String max_price) { this.max_price = max_price; }

    public String getAvg_price() { return avg_price; }

    public void setAvg_price(String avg_price) { this.avg_price = avg_price; }


    // 3.序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeUTF(date);
        dataOutput.writeUTF(variety);
        dataOutput.writeUTF(min_price);
        dataOutput.writeUTF(max_price);
        dataOutput.writeUTF(avg_price);
    }

    // 4.反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.date = dataInput.readUTF();
        this.variety = dataInput.readUTF();
        this.min_price = dataInput.readUTF();
        this.max_price = dataInput.readUTF();
        this.avg_price = dataInput.readUTF();
    }

    // 5.从DB读取
    @Override
    public void readFields(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt(1); // 1,2,3对应列的坐标，从1开始
        date = resultSet.getString(2);
        variety = resultSet.getString(3);
        min_price = resultSet.getString(4);
        max_price = resultSet.getString(5);
        avg_price = resultSet.getString(6);
    }

    // 6.写入数据库
    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, variety);
        preparedStatement.setString(2, min_price);
        preparedStatement.setString(3, max_price);
        preparedStatement.setString(4, avg_price);
    }

}
