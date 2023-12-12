package com.cityWeather.wind;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class windMapper extends Mapper<LongWritable, windBean, Text, Text> {
    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, windBean value, Context context) throws IOException, InterruptedException {
        String province = value.getProvince();
        String city = value.getCity();
        String windDir = value.getWindDir();
        String windLevel = value.getWindLevel();

        String str;
        str = city + "\t" + province + "\t" + windDir + "\t" + windLevel;

        outK.set(province);
        outV.set(str);
        context.write(outK, outV);
    }
}
