package com.bigdata1901.prices;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class JDBCReduce extends Reducer<Text, Text, MyDBWritable, NullWritable> {
//    Double max = 0.0;
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        MyDBWritable myDBName = new MyDBWritable();
        Double mins = new Double(10.0);
        Double maxs = new Double(0.0);
        Double avgs = new Double(0.0);
//        text = values.iterator().next();
//        MyDBWritable myDBM_price = new MyDBWritable();
        myDBName.setVariety(key.toString());
        for (Text value : values){
            String[] priceStr = value.toString().split("\t");
            Double min = Double.parseDouble(priceStr[0]);
            Double max = Double.parseDouble(priceStr[1]);
            Double avg = Double.parseDouble(priceStr[2]);
            if(min == 0.0 || max == 0.0 || avg == 0.0){
                continue;
            }
            if(mins > min) {
                mins = min;
            }
            if(maxs < max) {
                maxs = max;
            }
            if(avgs < avg) {
                avgs = avg;
            }
        }

        myDBName.setMin_price(mins.toString());
        myDBName.setMax_price(maxs.toString());
        myDBName.setAvg_price(avgs.toString());
        context.write(myDBName, NullWritable.get());
    }
}

