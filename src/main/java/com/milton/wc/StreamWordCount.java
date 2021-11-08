package com.milton.wc;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author miton_liu
 * @title: StreamWordCount
 * @projectName flink_study
 * @description: nc -lk 1111
 * @date 2021/11/110:36
 */
public class StreamWordCount {
    public static void main(String[] args) throws Exception {

        ParameterTool fromArgs  = ParameterTool.fromArgs(args);
//        String host = fromArgs.get("host");
//        int port = fromArgs.getInt("port");

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> inputStream = env.socketTextStream("localhost", 1111);


        DataStream<Tuple2<String, Integer>> resultStream = inputStream.flatMap(new MyMapper())
//                .slotSharingGroup("green")
                .keyBy(0)
                .sum(1);
               // .setParallelism(2)
//                .slotSharingGroup("red");


        resultStream.print().setParallelism(1);

        env.execute();
    }
}
