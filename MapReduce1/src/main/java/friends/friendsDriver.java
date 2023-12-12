package friends;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import sun.text.normalizer.CharTrie;


public class friendsDriver {
    public static void main(String[] args) throws Exception {
        //1：获取Job对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //2:设置jar
        job.setJarByClass(friendsDriver.class);

        //3:关联Mapper和reducer
        job.setMapperClass(friendsMapper.class);
        job.setReducerClass(friendsReducer.class);

        //4:设置mapper输出参数
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        //5：设置最终输出
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        //6:设置文件输入输出路径
        FileInputFormat.setInputPaths(job, new Path("Inputs/friend"));
        FileOutputFormat.setOutputPath(job, new Path("Outputs/friend"));

        //7：提交
        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);
    }
}
