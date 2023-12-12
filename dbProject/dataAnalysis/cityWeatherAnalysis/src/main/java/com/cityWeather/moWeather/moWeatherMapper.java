package com.cityWeather.moWeather;

import com.sun.javaws.jnl.RContentDesc;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class moWeatherMapper extends Mapper<LongWritable, moWeatherBean, Text, Text >{
    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, moWeatherBean value, Context context) throws IOException, InterruptedException {

        String month = value.getMonth();
        String weather = value.getWeather();

        String str;
        str = month + "\t" + weather;

        outK.set(str);
        outV.set(weather);
        context.write(outK,outV);

    }
}
