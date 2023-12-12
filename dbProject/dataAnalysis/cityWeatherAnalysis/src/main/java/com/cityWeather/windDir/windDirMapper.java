package com.cityWeather.windDir;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class windDirMapper extends Mapper<LongWritable, windDirBean, Text, Text> {
    private Text outK = new Text();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, windDirBean value, Context context) throws IOException, InterruptedException {
        String province = value.getProvince();
        String city = value.getCity();
        String windDir = value.getWindDir();

        String str;
        str = city + "\t" + province + "\t" + windDir;

        outK.set(province);
        outV.set(str);
        context.write(outK, outV);
    }
}
