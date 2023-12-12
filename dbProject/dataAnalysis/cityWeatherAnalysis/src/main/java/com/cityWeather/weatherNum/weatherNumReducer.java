package com.cityWeather.weatherNum;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class weatherNumReducer extends Reducer<Text, Text, weatherNumBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        weatherNumBean weatherNumBean = new weatherNumBean();

        Integer weatherNum = new Integer(0);
        Map<String, Integer> dict = new HashMap<String, Integer>();

        for (Text value : values) {
            String weather = value.toString();
            if (dict.containsKey(weather)){
                Integer V = dict.get(weather);
                dict.put(weather, V+1);
            }else {
                dict.put(weather, 1);
            }
        }
        String[] str = key.toString().split("\t");
        String city = str[0];
        String province = str[1];
        for (String s : dict.keySet()) {
            weatherNum = dict.get(s);
            weatherNumBean.setCity(city);
            weatherNumBean.setProvince(province);
            weatherNumBean.setWeather(s);
            weatherNumBean.setWeatherNum(weatherNum);

            context.write(weatherNumBean, NullWritable.get());
        }
    }
}
