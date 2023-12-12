package com.cityWeather.weatherNum;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class weatherNumMapper extends Mapper<LongWritable, weatherNumBean, Text, Text> {
    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, weatherNumBean value, Context context) throws IOException, InterruptedException {
        String city = value.getCity();
        String province = value.getProvince();
        String weather = value.getWeather();

        String str;
        str = city + "\t" + province;

        outK.set(str);
        outV.set(weather);

        context.write(outK, outV);
    }
}
