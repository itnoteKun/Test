package com.cityWeather.moWeather;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;


public class moWeatherReducer extends Reducer<Text,Text,moWeatherBean,NullWritable>{

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        moWeatherBean moWeather = new moWeatherBean();
        Integer weatherSum = new Integer(0);


        for (Text value : values){
            weatherSum = weatherSum + 1;
        }

        String[] str = key.toString().split("\t");
        String month = str[0];
        String weather = str[1];

        moWeather.setMonth(month);
        moWeather.setWeather(weather);
        moWeather.setWeatherSum(weatherSum);

        context.write(moWeather,NullWritable.get());

    }
}
