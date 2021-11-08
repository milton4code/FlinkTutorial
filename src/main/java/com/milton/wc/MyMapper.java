package com.milton.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author miton_liu
 * @title: MyMapper
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/111:04
 */
public class MyMapper implements FlatMapFunction<String, Tuple2<String,Integer>> {
    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
        //  按空格分词
        String[] words = value.split(" ");
        // 遍历所有word，包成二元组输出
        for (String word : words) {
            out.collect(new Tuple2<String, Integer>(word, 1));
        }
    }
}
