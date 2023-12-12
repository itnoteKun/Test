package com.cityWeather.weatherAvgWdLevel;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class avgWdLevelMapper extends Mapper<LongWritable, avgWdLevelBean, Text, Text> {
    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key,avgWdLevelBean value, Context context) throws IOException, InterruptedException {
        String weather = value.getWeather();
        String windLevel = value.getWindLevel();

        String str;
        str = weather + "\t" + windLevel;

        outK.set(weather);
        outV.set(str);
        context.write(outK, outV);
    }
}
