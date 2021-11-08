package com.milton.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* @title: java8 方法引用
* @projectName flink_study
* @description: TODO
* @author miton_liu
* @date 2021/11/38:53
*/public interface MethodReference {


    public static void main(String[] args) {
//        extracted1();

        extracted();

    }

    static void extracted1() {

        // 构造器引用：它的语法是Class::new，或者更一般的Class< T >::new
        Car car = Car.create(Car::new);
        List<Car> cars = Collections.singletonList(car);

//        静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(Car::collide);

//        特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(Car::repair);

//        特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create( Car::new );
        cars.forEach(police::follow);
    }

    static void extracted() {
        List<String> names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }

    public interface  供应商<T>{

        T get();
    }

    class Car{

        public static Car create (final  供应商<Car> supplier){
            return supplier.get();
        }
        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }

}
