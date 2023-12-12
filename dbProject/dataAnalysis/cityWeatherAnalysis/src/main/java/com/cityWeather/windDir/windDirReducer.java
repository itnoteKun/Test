package com.cityWeather.windDir;


import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class windDirReducer extends Reducer<Text, Text, windDirBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        windDirBean windDirBean = new windDirBean();

        Integer windDirNum = new Integer(0);
        Map<String, Integer> dict = new HashMap<String, Integer>();
        for (Text value : values) {
            String[] Str = value.toString().split("\t");
            String city = Str[0];
            String province = Str[1];
            String windDir = Str[2];
            windDirBean.setCity(city);
            windDirBean.setProvince(province);
            if (dict.containsKey(windDir)){
                Integer V = dict.get(windDir);
                dict.put(windDir, V+1);
            }else {
                dict.put(windDir, 1);
            }
        }
        for (String s : dict.keySet()) {
            windDirNum = dict.get(s);
            windDirBean.setWindDir(s);
            windDirBean.setWindDirNum(Integer.toString(windDirNum));
            context.write(windDirBean, NullWritable.get());
        }
    }
}
