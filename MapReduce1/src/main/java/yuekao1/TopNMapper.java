package yuekao1;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TopNMapper extends Mapper<LongWritable,  Text, FlowBean, Text> {



        private final FlowBean outK = new FlowBean();
        private final Text outV = new Text();


        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, FlowBean, Text>.Context context) throws IOException, InterruptedException {
            String line = value.toString();

            String[] split = line.split("\t");

            outV.set(split[0]);
            outK.setUpFlow(Long.parseLong(split[1]));
            outK.setDownFlow(Long.parseLong(split[2]));
            outK.setSumFlow();

            context.write(outK,outV);

    }



}
