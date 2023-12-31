package com.bigdata1901.number;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.mapred.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;

import java.io.IOException;

public class JDBCDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // 1.获取job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 2.设置jar路径
        job.setJarByClass(JDBCDriver.class);
        // 3.数据输入类型为数据库输入
        job.setInputFormatClass(DBInputFormat.class); //read
        // 4.设置数据库配置并且连接
        String driverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.10.101:3306/agricultural?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
        String userName = "root";
        String passWord = "123456";

        DBConfiguration.configureDB(job.getConfiguration(), driverClass, url,
                userName, passWord);

        // 5.设置数据输入内容-sql查询数据作为输入数据
        DBInputFormat.setInput(job, MyDBWritable.class,
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
