package inverted_index;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class indexReduce extends Reducer<Text, Text, Text, Text> {
    private static Text result = new Text();
    @Override
    protected void  reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
        String ouValues = new String();
        for(Text value : values){
            ouValues += value.toString() + " ";
        }
        result.set(ouValues);
        context.write(key,result);
    }
}
