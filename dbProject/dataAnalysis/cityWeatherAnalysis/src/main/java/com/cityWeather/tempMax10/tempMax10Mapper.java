package com.cityWeather.tempMax10;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class tempMax10Mapper extends Mapper<LongWritable, tempMax10Bean, Text, Text> {
    private Text outK = new Text();
//    private tempMax10Bean outV = new tempMax10Bean();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, tempMax10Bean value, Context context) throws IOException, InterruptedException {
        String city = value.getCity();
        String province = value.getProvince();
        String tempMax = value.getTempMax();

        String s = new String();
        s = city + '\t' + province;
        outK.set(s);

        outV.set(tempMax);
        context.write(outK, outV);
    }
}
