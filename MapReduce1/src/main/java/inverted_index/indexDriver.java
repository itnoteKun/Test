package inverted_index;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class indexDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        //获取job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //jar路径
        job.setJarByClass(indexDriver.class);
        //关联class
        job.setMapperClass(indexMapper.class);
        job.setCombinerClass(indexCombiner.class);
        job.setReducerClass(indexReduce.class);
        //最终输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //6.设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("D:\\idea_project\\Inputs\\zuoye1"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\idea_project\\Outputs\\zuoye1"));

        //7.提交job
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }


}
