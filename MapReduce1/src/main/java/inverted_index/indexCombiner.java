package inverted_index;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class indexCombiner extends Reducer<Text, Text, Text, Text> {
    private static Text outValue = new Text();

    @Override
    protected  void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
        int sum=0;
        for (Text value : values){
            sum +=Integer.parseInt(value.toString());
        }
        int splitIndex = key.toString().indexOf("--");//获取--首次出现的index

        outValue.set(key.toString().substring(splitIndex + 2) + "-->" + sum);
        key.set(key.toString().split("--")[0]);
        context.write(key,outValue);
    }
}


