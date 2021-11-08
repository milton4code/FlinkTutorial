package com.milton.source;

import com.milton.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * @ClassName: SourceTest1_Collection
 * @Author milton.liu on 2021/11/318:04
 * @Description: TODO
 */
public class SourceTest1_Collection {
    public static  void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // 从集合中读取数据
        DataStreamSource<SensorReading> dataStreamSource = env.fromCollection(Arrays.asList(
                new SensorReading("sensor_1", 1547718199L, 35.8),
                new SensorReading("sensor_6", 1547718201L, 15.4),
                new SensorReading("sensor_7", 1547718202L, 6.7),
                new SensorReading("sensor_10", 1547718205L, 38.1)));

        DataStreamSource<Integer> integerDataStreamSource = env.fromElements(1, 3, 2, 37, 199);

        dataStreamSource.print();
        integerDataStreamSource.print();

        env.execute();
    }

}
