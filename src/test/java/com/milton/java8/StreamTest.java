package com.milton.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author miton_liu
 * @title: 流式计算
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/310:19
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> collectString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//        System.out.println(collectString);


        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

        System.out.println("-------------map-------------------------------");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect2 = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//        System.out.println(collect2);

        System.out.println("----------------sorted-------------------");
//        random.ints().limit(5).sorted().forEach(System.out::println);

        // parallelStream 是流并行处理程序的代替方法。
        List<String> parallelStreamString = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        parallelStreamString(parallelStreamString);

        statistics();



    }


    private static void statistics(){
        //另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();

        System.out.println(" getMax:::" +intSummaryStatistics.getMax());
        System.out.println(" getMin:::" +intSummaryStatistics.getMin());
        System.out.println(" getSum:::" +intSummaryStatistics.getSum());
        System.out.println(" getAverage:::" +intSummaryStatistics.getAverage());

    }


    private  static void collectos(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

    }

    private static void parallelStreamString(List<String> parallelStreamString) {
        // 获取空字符串的数量
        long count = parallelStreamString.parallelStream().filter(String::isEmpty).count();
        System.out.println("==========count===========" + count) ;
    }
}
