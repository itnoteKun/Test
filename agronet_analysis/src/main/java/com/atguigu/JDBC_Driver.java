package com.atguigu;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.lib.db.DBInputFormat;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;


import java.io.IOException;

public class JDBC_Driver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //1.获取job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //2.设置jar路径
        job.setJarByClass(JDBC_Driver.class);

        //3.数据输入类型为数据库输入
        job.setInputFormatClass(DBInputFormat.class);

        //4.数据配置、连接
        String driverClass = "com.mysql.jdbc.Driver";//mysql驱动
        String url = "jdbc:mysql://192.168.10.102:3306/spider_agronet?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
        String userName = "root";
        String userPassword = "123456";
        DBConfiguration.configureDB(job.getConfiguration(), driverClass, url, userName, userPassword);

        //
        DBConfiguration.configureDB(job.getConfiguration(), driverClass, url,
                userName, passWord);

        // 5.设置数据输入内容-sql查询数据作为输入数据
        DBInputFormat.setInput(job, .class,
                "select id,date,variety,city,city_short,market,minPrice,maxPrice,avgPrice,num from cityNumber",
                "select count(*) from cityNumber");
        // 6.设置输出的表
        DBOutputFormat.setOutput(job,"cityNumberClean","city","city_short","min_price","max_price","avg_price","num");
        // 7.关联mapper和reducer
        job.setMapperClass(JDBCMapper.class);
        job.setReducerClass(JDBCReduce.class);

        // 8.设置map输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        // 9.设置最终输出的kv类型
        job.setOutputKeyClass(MyDBWritable.class);
        job.setOutputValueClass(NullWritable.class);

        // 10.提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);






        }
    }








