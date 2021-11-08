package com.milton.wc;

import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * @author milton
 * @title: WorldCount
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/19:30
 */
public class WorldCount {
    public static void main(String[] args) throws Exception {

         // 创建执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        String inputPath = "file:///tmp/flink/source/hello.txt";
        // 从文件中读取数据
        DataSet<String> inputDataSet = env.readTextFile(inputPath);

        // 空格分词打散之后，对单词进行 groupby 分组，然后用 sum 进行聚合
        DataSet<Tuple2<String,Integer>> resultSet = inputDataSet.flatMap(new MyMapper()).groupBy(0)
                .sum(1);

        resultSet.print();
    }
}
