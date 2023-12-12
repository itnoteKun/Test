package com.atguigu.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Test;

import java.io.IOException;

/**
 * KEYIN  map阶段输入的key的类型：LongWritable
 * VALUEIN  map阶段输入的value的类型：Test
 * KEYOUT  map阶段输出的key类型：Test
 * VALUEOUT  map阶段输出的value类型：IntWritable
 * */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

    private Text outK = new Text();
    private IntWritable outV = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //获取一行
        String line = value.toString();

        //切割
        String[] words = line.split(" ");

        //循环写出
        for (String word : words) {
            //封装outK
            outK.set(word);

            //写出
            context.write(outK,outV);
        }
    }
}
