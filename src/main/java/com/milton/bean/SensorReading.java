package com.milton.bean;

/**
 * @ClassName: 传感器温度读数的数据类型
 * @Author milton.liu on 2021/11/318:10
 * @Description: TODO
 */

public class SensorReading {

    // 属性：id，时间戳，温度值
    private String id;
    private Long timestamp;
    private Double temperature;

    public SensorReading(){

    }
    public SensorReading(String id, Long timestamp, Double temperature) {
        this.id = id;
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", temperature=" + temperature +
                '}';
    }
}
