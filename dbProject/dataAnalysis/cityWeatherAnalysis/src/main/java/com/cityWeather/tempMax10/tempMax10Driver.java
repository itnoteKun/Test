package com.cityWeather.tempMax10;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;

import java.io.IOException;

public class tempMax10Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //获取job
        Job job = Job.getInstance(new Configuration());

        //设置jar路径
        job.setJarByClass(tempMax10Bean.class);

        //设置数据输入类型为数据库输入
        job.setInputFormatClass(DBInputFormat.class);

        //设置数据库配置并连接
        String driverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.10.102:3306/dbAnalysis";
        String usr = "root";
        String pwd = "123456";

        DBConfiguration.configureDB(job.getConfiguration(), driverClass, url, usr, pwd);

        //设置数据输入内容
        DBInputFormat.setInput(job, tempMax10Bean.class,
                "select * from cityWeather",
                "select count(*) from cityWeather");

        //设置输出的表
        DBOutputFormat.setOutput(job, "tempMax10", "city", "province", "tempMax");

        //关联mapper与reducer
        job.setMapperClass(tempMax10Mapper.class);
        job.setCombinerClass(tempMax10Combiner.class);
        job.setReducerClass(tempMax10Reducer.class);

        //设置map阶段输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        //设置最终输出的kv类型
        job.setOutputKeyClass(tempMax10Bean.class);
        job.setOutputValueClass(NullWritable.class);

        //提交job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}
