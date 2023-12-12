package com.cityWeather.regionTemp;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class regionTmpReducer extends Reducer<Text, Text, regionTempBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        regionTempBean regionTempBean = new regionTempBean();
        Integer tempMax = new Integer(0);
        Integer tempMin = new Integer(0);
        int index = 0;

        for (Text value : values) {
            String[] s = value.toString().split("\t");

            //临时最高温度，最低温度
            Integer tempMaxTemp = Integer.parseInt(s[0]);
            Integer tempMinTemp = Integer.parseInt(s[1]);

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
            index += 1;
        }
        System.out.println(tempMin);
        regionTempBean.setRegion(key.toString());
        regionTempBean.setTempMax(Integer.toString(tempMax));
        regionTempBean.setTempMin(Integer.toString(tempMin));

        context.write(regionTempBean, NullWritable.get());
    }
}
