package com.milton.source;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @ClassName: 从文件读取数据
 * @Author milton.liu on 2021/11/48:55
 * @Description: TODO
 */
public class SourceTest2_File {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> stream = env.readTextFile("file:///tmp\\flink\\source\\hello.txt");


        stream.print();
        env.execute();
    }
}
