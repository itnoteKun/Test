package com.cityWeather.averageTemp;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class averageReducer extends Reducer<Text, Text, averageBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        averageBean cityWeather = new averageBean();
        Integer tempMax = new Integer(0);
        Integer tempMin = new Integer(0);
        Integer tempAVGtoday = new Integer(0);
        Integer tempAVG = new Integer(0);
        Integer tempAVGsum = new Integer(0);

        for (Text value : values) {
            String[] Str = value.toString().split("\t");
            String city = Str[0];

            //临时最高温度，最低温度,临时每日平均温度=临时最高加最低平均因为缺数据
            Integer tempMaxTemp = Integer.parseInt(Str[1]);
            Integer tempMinTemp = Integer.parseInt(Str[2]);
            Integer tempAVGTemp = (Integer.parseInt(Str[1])+Integer.parseInt(Str[2]))/2;
            tempAVGtoday= tempAVGTemp;
            tempAVGsum=tempAVGtoday+tempAVGsum;
            cityWeather.setCity(city);
        }
        tempAVG=tempAVGsum/365;
        cityWeather.setTempAVG(tempAVG);
        context.write(cityWeather, NullWritable.get());
    }
}
