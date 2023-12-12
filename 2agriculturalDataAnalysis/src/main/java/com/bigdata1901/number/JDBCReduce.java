package com.bigdata1901.number;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class JDBCReduce extends Reducer<Text, Text, MyDBWritable, NullWritable> {
    int nums = 0;
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        MyDBWritable myDBCity = new MyDBWritable();
        Double mins = new Double(10.0);
        Double maxs = new Double(0.0);
        Double avgs = new Double(0.0);
//        text = values.iterator().next();
//        MyDBWritable myDBM_price = new MyDBWritable();
        myDBCity.setCity(key.toString());
        for (Text value : values){
            String[] Str = value.toString().split("\t");
            String city_short = Str[0];
            Double min = Double.parseDouble(Str[1]);
            Double max = Double.parseDouble(Str[2]);
            Double avg = Double.parseDouble(Str[3]);
            int num = Integer.parseInt(Str[4]);
            if(min == 0.0 || max == 0.0 || avg == 0.0){
                continue;
            }
            nums = nums + num;
            if(mins > min) {
                mins = min;
            }
            if(maxs < max) {
                maxs = max;
            }
            if(avgs < avg) {
                avgs = avg;
            }
            myDBCity.setCity_short(city_short);
        }
        myDBCity.setMin_price(mins.toString());
        myDBCity.setMax_price(maxs.toString());
        myDBCity.setAvg_price(avgs.toString());
        myDBCity.setNum(nums);
        context.write(myDBCity, NullWritable.get());
    }
}

