package com.cityWeather.tempMax10;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class tempMax10Combiner extends Reducer<Text, Text, Text, Text> {
    private Text outV = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Integer tempMax = new Integer(0);
        for (Text value : values) {
            Integer tempMaxTemp = Integer.parseInt(value.toString());
            if (tempMax < tempMaxTemp) {
                tempMax = tempMaxTemp;
            }
        }
        outV.set(Integer.toString(tempMax));
        context.write(outV, key);
    }
}
