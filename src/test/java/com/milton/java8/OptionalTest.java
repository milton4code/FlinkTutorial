package com.milton.java8;

import java.util.Optional;

/**
 * test
 * @author miton_liu
 * @title: Optional 测试
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/310:54
 */
public class OptionalTest {

    public static void main(String[] args) {

        OptionalTest optionalTest = new OptionalTest();

        Integer value1 = null;
        Integer value2 = 10;


        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> v1 = Optional.ofNullable(value1);

        Optional<Integer> v2 = Optional.of(value2);

        System.out.println(optionalTest.sum(v1, v2));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(0);

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();


        return value1 + value2;
    }
}
