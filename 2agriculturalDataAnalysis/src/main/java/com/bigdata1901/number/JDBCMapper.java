package com.bigdata1901.number;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class JDBCMapper extends Mapper<LongWritable, MyDBWritable, Text, Text> {
    private Text text = new Text();
    private Text outWritable = new Text();
//    private MyDBWritable price = new MyDBWritable();
    @Override
    protected void map(LongWritable key, MyDBWritable value, Context context) throws IOException, InterruptedException {
        String city = value.getCity(); // city作为键
        String city_short = value.getCity_short();
        String min_price = value.getMin_price();
        String max_price = value.getMax_price();
        String avg_price = value.getAvg_price();
        int num = value.getNum();
        String str;
        str = city_short + "\t" + min_price + "\t" + max_price + "\t" + avg_price+ "\t" + num;
        text.set(city);
        outWritable.set(str);
        context.write(text, outWritable);
    }
}
