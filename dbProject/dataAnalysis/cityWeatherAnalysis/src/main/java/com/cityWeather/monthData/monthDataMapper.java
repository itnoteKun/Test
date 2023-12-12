package com.cityWeather.monthData;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class monthDataMapper extends Mapper<LongWritable, monthDataBean, Text, Text> {
    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, monthDataBean value, Context context) throws IOException, InterruptedException {
        String city = value.getCity();
        String month = value.getMonth();
        String province = value.getProvince();
        String tempMax = value.getTempMax();
        String tempMin = value.getTempMin();
        String windLevel = value.getWindLevel();

        String str0;
        str0 = city + "\t" + province + "\t" + month;

        String str1;
        str1 = tempMax + "\t" + tempMin + "\t" + windLevel;

        outK.set(str0);
        outV.set(str1);

        context.write(outK, outV);
    }
}
