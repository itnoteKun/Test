package com.cityWeather.regionTemp;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class regionTempMapper extends Mapper<LongWritable, regionTempBean, Text, Text> {
    private Text outK = new Text();
    private Text outV = new Text();

    //初始化省份-->地区的映射
    private Map<String, String> dict = new HashMap<String, String>();

    @Override
    protected void map(LongWritable key, regionTempBean value, Context context) throws IOException, InterruptedException {
        dict.put("上海", "华东地区");
        dict.put("江苏", "华东地区");
        dict.put("浙江", "华东地区");
        dict.put("安徽", "华东地区");
        dict.put("江西", "华东地区");
        dict.put("山东", "华东地区");
        dict.put("福建", "华东地区");
        dict.put("台湾", "华东地区");
        dict.put("北京", "华北地区");
        dict.put("天津", "华北地区");
        dict.put("山西", "华北地区");
        dict.put("河北", "华北地区");
        dict.put("河南", "华中地区");
        dict.put("湖北", "华中地区");
        dict.put("湖南", "华中地区");
        dict.put("广东", "华南地区");
        dict.put("广西", "华南地区");
        dict.put("海南", "华南地区");
        dict.put("香港", "华南地区");
        dict.put("澳门", "华南地区");
        dict.put("重庆", "西南地区");
        dict.put("四川", "西南地区");
        dict.put("贵州", "西南地区");
        dict.put("云南", "西南地区");
        dict.put("西藏", "西南地区");
        dict.put("陕西", "西北地区");
        dict.put("甘肃", "西北地区");
        dict.put("青海", "西北地区");
        dict.put("宁夏", "西北地区");
        dict.put("新疆", "西北地区");
        dict.put("内蒙古", "西北地区");
        dict.put("黑龙江", "东北地区");
        dict.put("吉林", "东北地区");
        dict.put("辽宁", "东北地区");

        String province = value.getProvince();
        String tempMax = value.getTempMax();
        String tempMin = value.getTempMin();

        String region = dict.get(province);
        String str = tempMax + "\t" + tempMin;

        outK.set(region);
        outV.set(str);

        context.write(outK, outV);
    }
}
