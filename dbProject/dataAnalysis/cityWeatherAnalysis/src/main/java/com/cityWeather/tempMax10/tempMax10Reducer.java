package com.cityWeather.tempMax10;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class tempMax10Reducer extends Reducer<Text, Text, tempMax10Bean, NullWritable> {
    private tempMax10Bean outK = new tempMax10Bean();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        for (Text value : values) {
            String[] s = value.toString().split("\t");
            String city = s[0];
            String province = s[1];

            outK.setCity(city);
            outK.setProvince(province);
            outK.setTempMax(key.toString());

            context.write(outK, NullWritable.get());
            }
    }
}
