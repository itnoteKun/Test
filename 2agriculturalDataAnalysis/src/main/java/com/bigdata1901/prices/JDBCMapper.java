package com.bigdata1901.prices;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class JDBCMapper extends Mapper<LongWritable,MyDBWritable, Text, Text> {
    private Text text = new Text();
    private Text outWritable = new Text();
//    private MyDBWritable price = new MyDBWritable();
    @Override
    protected void map(LongWritable key, MyDBWritable value, Context context) throws IOException, InterruptedException {
        String name = value.getVariety(); // 读取每一行的年龄作为K
        String min_price = value.getMin_price();
        String max_price = value.getMax_price();
        String avg_price = value.getAvg_price();
        String price;
        price = min_price + "\t" + max_price + "\t" + avg_price;
        text.set(name);
        outWritable.set(price);
        context.write(text, outWritable);
    }
}
