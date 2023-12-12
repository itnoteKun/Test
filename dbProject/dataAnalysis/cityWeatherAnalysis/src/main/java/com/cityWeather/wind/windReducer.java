package com.cityWeather.wind;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class windReducer extends Reducer<Text, Text, windBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        windBean cityWind = new windBean();

        Integer windLevelMax = new Integer(0);
        for (Text value : values) {
            String[] Str = value.toString().split("\t");
            String city = Str[0];
            String province = Str[1];

            //临时最高风力
            Integer windMaxTemp = Integer.parseInt(Str[3]);
            if (windLevelMax < windMaxTemp){
                windLevelMax = windMaxTemp;
            }

            cityWind.setCity(city);
            cityWind.setProvince(province);
            //System.out.println((city + province + Integer.toString(windLevelMax)));
        }
        cityWind.setWindLevel(Integer.toString(windLevelMax));

        context.write(cityWind, NullWritable.get());
    }
}
