package com.cityWeather.monthData;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class monthDataReducer extends Reducer<Text, Text, monthDataBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        monthDataBean monthData = new monthDataBean();

        Integer tempMax = new Integer(0);
        Integer tempMin = new Integer(0);
        Integer windLevel = new Integer(0);
        int index = 0;
        for (Text value : values) {
            String[] s = value.toString().split("\t");

            //临时最高温度，最低温度
            Integer tempMaxTemp = Integer.parseInt(s[0]);
            Integer tempMinTemp = Integer.parseInt(s[1]);
            Integer windLevelTemp = Integer.parseInt(s[2]);

            //比较
            if (tempMax < tempMaxTemp) {
                tempMax = tempMaxTemp;
            }

            //由于设置最低温度初始值为0，所以第一次需要直接赋值
            if (index < 1) {
                tempMin = tempMinTemp;
            } else {
                if (tempMinTemp < tempMin) {
                    tempMin = tempMinTemp;
                }
            }

            if (windLevel < windLevelTemp) {
                windLevel = windLevelTemp;
            }
        }
        String[] str = key.toString().split("\t");
        String city = str[0];
        String province = str[1];
        String month = str[2];

        monthData.setCity(city);
        monthData.setProvince(province);
        monthData.setMonth(month);
        monthData.setTempMax(Integer.toString(tempMax));
        monthData.setTempMin(Integer.toString(tempMin));
        monthData.setWindLevel(Integer.toString(windLevel));

        context.write(monthData, NullWritable.get());
    }
}
