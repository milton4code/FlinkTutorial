package com.milton.java8;

/**
 * @author miton_liu
 * @title: java接口实现方法
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/310:00
 */
public class InterfaceDefaultTest {

    public static void main(String[] args) {
        new Car().print();
    }
}

// Java 8 的另一个特性是接口可以声明（并且可以提供实现）静态方法。例如：
interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }

    // 静态方法
    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}

class Car implements Vehicle,FourWheeler{

    @Override
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        // 静态方法直接调用
        Vehicle.blowHorn();

        System.out.println("我是一辆汽车!");


    }
}