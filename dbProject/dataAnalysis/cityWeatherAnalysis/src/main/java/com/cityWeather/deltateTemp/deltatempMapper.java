package com.cityWeather.deltateTemp;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class deltatempMapper extends Mapper<LongWritable, deltatempBean, Text, Text> {
    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, deltatempBean value, Context context) throws IOException, InterruptedException {
        String city = value.getCity();
        String tempMax = value.getTempMax();
        String tempMin = value.getTempMin();

        String str;
        str = city + "\t" + tempMax + "\t" + tempMin;

        outK.set(city);
        outV.set(str);
        context.write(outK, outV);
    }
}
