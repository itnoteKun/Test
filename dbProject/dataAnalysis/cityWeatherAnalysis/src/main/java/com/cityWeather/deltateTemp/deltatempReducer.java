package com.cityWeather.deltateTemp;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class deltatempReducer extends Reducer<Text, Text, deltatempBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        deltatempBean cityWeather = new deltatempBean();
        Integer tempMax = new Integer(0);
        Integer tempMin = new Integer(0);
        Double standard_avetemp = new Double(0);
        Integer avetemponeday_square = new Integer(0);
        Integer avetempsum = new Integer(0);
        Integer day = new Integer(0);
        for (Text value : values) {
            String[] Str = value.toString().split("\t");
            String city = Str[0];

            day = day + 1;
            //
            Integer tempMaxTemp = Integer.parseInt(Str[1]);
            Integer tempMinTemp = Integer.parseInt(Str[2]);
            Integer tempaveTemp = (Integer.parseInt(Str[1])+Integer.parseInt(Str[2]))/2;
            avetemponeday_square = tempaveTemp*tempaveTemp;
            avetempsum=avetemponeday_square+avetempsum;
            cityWeather.setCity(city);
        }
        standard_avetemp= Math.sqrt(avetempsum / day);
        cityWeather.setStandardAveTemp(standard_avetemp);
        context.write(cityWeather, NullWritable.get());
    }
}
