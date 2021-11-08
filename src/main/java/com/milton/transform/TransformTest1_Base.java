package com.milton.transform;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import java.util.Arrays;

/**
 * @ClassName: TransformTest1_Base
 * @Author milton.liu on 2021/11/417:22
 * @Description: TODO
 */
public class TransformTest1_Base {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStreamSource<String> streamSource = env.readTextFile("file:///projects\\flink_study\\FlinkTutorial\\src\\main\\resources\\sensor.txt");

        DataStream<Tuple2<String,Integer>> mapStream = streamSource.map(new MapFunction<String, Tuple2<String,Integer>>() {
            @Override
            // map函数输出字符串长度
            public Tuple2<String,Integer> map(String value) throws Exception {
                return new Tuple2<>(value, value.length());
            }
        });
        // 2. flatmap，按逗号分字段
        DataStream<String> flatMapStream = streamSource.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String value, Collector<String> out) throws Exception {
                Arrays.stream(value.split(",")).forEach(out::collect);
            }
        });

        // 3. filter, 筛选sensor_1开头的id对应的数据
        DataStream<String> filterStream = streamSource.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                return value.startsWith("sensor_1");

            }
        });

        mapStream.print();
        System.out.println("------------------------------------------");
        flatMapStream.print();
        System.out.println("------------------------------------------");
        filterStream.print();

        env.execute();

    }


}
