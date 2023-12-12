package Max10_math;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.TreeMap;

public class MaxMapper extends Mapper<LongWritable, Text, NullWritable, IntWritable> {
    private TreeMap<Integer, String> repToRecordMap = new TreeMap<Integer, String>();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        String[] nums = line.split(" ");
        for (String num : nums){
            repToRecordMap.put(Integer.parseInt(num), " ");
            if (repToRecordMap.size() > 10) {
                repToRecordMap.remove(repToRecordMap.firstKey());
        }
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        super.cleanup(context);
        for (Integer i : repToRecordMap.keySet()) {
            try {
                context.write(NullWritable.get(), new IntWritable(i));
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

