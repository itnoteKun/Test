package inverted_index;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class indexMapper extends Mapper<LongWritable, Text, Text, Text> {
    private static Text inKey = new Text();
    private static final   Text inValue = new Text("1");

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String line = value.toString();
        String[] words = line.split(" ");

        FileSplit fileSplit = (FileSplit) context.getInputSplit();
        String fileName = fileSplit.getPath().getName();//得到文件名
        for (String field : words){
            inKey.set(field + "--" + fileName);
            context.write(inKey, inValue);
        }
    }



}
