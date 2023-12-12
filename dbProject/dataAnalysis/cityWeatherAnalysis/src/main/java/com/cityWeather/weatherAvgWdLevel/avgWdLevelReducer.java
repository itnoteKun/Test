package com.cityWeather.weatherAvgWdLevel;



import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class avgWdLevelReducer extends Reducer<Text, Text, avgWdLevelBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        avgWdLevelBean Weather_WL = new avgWdLevelBean();
        Integer WindLevelsum = new Integer(0);
        Integer windSum = new Integer(0);

        Integer avgWindLevel = new Integer(0);

        for (Text value : values) {
            String[] Str = value.toString().split("\t");
            String weather = Str[0];
            Integer windLevel = Integer.parseInt(Str[1]);

            windSum = windSum + 1; // 风级次数

            WindLevelsum = WindLevelsum + windLevel; // 风级总和
            Weather_WL.setWeather(weather);
        }
        avgWindLevel = WindLevelsum /windSum;


                Weather_WL.setAvgWindLevel(avgWindLevel);
        context.write(Weather_WL, NullWritable.get());
    }
}
