package Max10_math;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Comparator;
import java.util.TreeMap;

public class MaxReducer  extends Reducer<NullWritable, IntWritable,NullWritable,IntWritable>{
    private TreeMap<Integer, String> repToRecordMap = new TreeMap<Integer, String>(new Comparator<Integer>() {
        /**
         * 谁大排后面
         *
         * @param a
         * @param b
         * @return 一个整数
         */
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

    public void reduce(NullWritable key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        for (IntWritable value : values) {
            repToRecordMap.put(value.get(), " ");
            if (repToRecordMap.size() > 10) {
                repToRecordMap.remove(repToRecordMap.firstKey());
            }
        }

        for (Integer i : repToRecordMap.keySet()) {
            context.write(NullWritable.get(), new IntWritable(i));
        }
    }

}

