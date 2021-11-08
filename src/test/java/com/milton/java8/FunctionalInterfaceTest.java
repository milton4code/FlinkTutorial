package com.milton.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author miton_liu
 * @title: 函数式接口
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/39:36
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        GreetingService greetingService = ((message, world) -> {
            System.out.println(message+ world);
        });

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        eval(list,n -> true);

        System.out.println("-------------------------------------------");
        eval(list,n-> n %2 == 0);

    }







    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}

@FunctionalInterface
interface GreetingService
{
    void sayMessage(String message,String world);
}
