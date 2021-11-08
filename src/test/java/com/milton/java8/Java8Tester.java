package com.milton.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author miton_liu
 * @title: Java8Tester
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/217:34
 */
public class Java8Tester {
    public static void main(String[] args) {
        List<String> names1 = new ArrayList<String>();
        names1.add("2Google ");
        names1.add("1Runoob ");
        names1.add("7Taobao ");
        names1.add("4Baidu ");
        names1.add("3Sina ");


        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina2    ");

        System.out.println("==========names1===============");
        Java8Tester java8Tester = new Java8Tester();
//        java8Tester.java7Sort(names1);
//        System.out.println(names1);

        System.out.println("==========names2===============");
        java8Tester.java8Sort(names1);
        System.out.println(names1);
    }


   private void java8Sort(List<String> lists){
//       lists.sort(String::compareTo);
//        Collections.sort(lists,(s1,s2)-> s1.compareTo(s2));
//        Collections.sort(lists,(s1,s2)-> s1.compareTo(s2));
       Collections.sort(lists, (s1, s2) -> s1.compareTo(s2));
   }

    private void java7Sort(List<String> lists){
        Collections.sort(lists, new Comparator<String>() {
            public int compare(String v1, String v2) {
                return  v1.compareTo(v2);
            }
        });

    }

}
