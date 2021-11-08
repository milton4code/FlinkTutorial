package com.milton.source;

import com.milton.bean.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.HashMap;
import java.util.Random;

/**
 * @ClassName: SourceTest4_UDF
 * @Author milton.liu on 2021/11/49:14
 * @Description: TODO
 */
public class SourceTest4_UDF {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // 读取数据
        DataStream<SensorReading> dataStream = env.addSource( new MySensorSource() );

        dataStream.print();

        env.execute();



    }

    public static class MySensorSource implements SourceFunction<SensorReading>{
        // 标示符
        private boolean running = true;

        @Override
        public void run(SourceContext<SensorReading> ctx) throws Exception {
            // 定义一个随机数发生器
            Random random = new Random();



            // 设置10个传感器的初始温度
            HashMap<String, Double> sensorTempMap = new HashMap<>();
            for( int i = 0; i < 10; i++ ){
                sensorTempMap.put("sensor_" + (i+1), 60 + random.nextGaussian() * 20);
            }

            while (running){
                sensorTempMap.forEach((sensorId, temperature)->{
                    // 在当前温度基础上随机波
                    double newtemp = temperature + random.nextGaussian();
                    sensorTempMap.put(sensorId, newtemp);
                    ctx.collect(new SensorReading(sensorId, System.currentTimeMillis(),newtemp));
                });

            }
            // 控制输出频率
            Thread.sleep(1000L);



        }

        @Override
        public void cancel() {
            running = false;
        }
    }
}
