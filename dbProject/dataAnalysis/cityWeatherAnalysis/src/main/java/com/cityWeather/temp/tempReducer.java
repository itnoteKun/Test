package com.cityWeather.temp;

import com.cityWeather.wind.windBean;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class tempReducer extends Reducer<Text, Text, tempSeqBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        tempSeqBean tempSeqBean = new tempSeqBean();
        Integer tempMax = new Integer(0);
        Integer tempMin = new Integer(0);

        for (Text value : values) {
            String[] Str = value.toString().split("\t");
            String city = Str[0];

            //临时最高温度，最低温度
            Integer tempMaxTemp = Integer.parseInt(Str[1]);
            Integer tempMinTemp = Integer.parseInt(Str[2]);

            if (tempMax < tempMaxTemp){
                tempMax = tempMaxTemp;
            }
            if (tempMinTemp < tempMin){
                tempMin = tempMinTemp;
            }

            tempSeqBean.setCity(city);
        }
        tempSeqBean.setTempMax(Integer.toString(tempMax));
        tempSeqBean.setTempMin(Integer.toString(tempMin));

        context.write(tempSeqBean, NullWritable.get());
    }
}
