package Max10_math;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MaxDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(MaxDriver.class);
        job.setMapperClass(MaxMapper.class);
        job.setReducerClass(MaxReducer.class);
        //最终输出类型
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(IntWritable.class);


        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(NullWritable.class);

        //6.设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("D:\\idea_project\\MapReduce1\\Inputs\\zuoye2"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\idea_project\\MapReduce1\\Outputs\\zuoye2"));

        //7.提交job
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);


    }

}
