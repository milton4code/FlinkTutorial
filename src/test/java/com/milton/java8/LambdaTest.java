package com.milton.java8;

/**
 * @author miton_liu
 * @title: LamdaTest
 * @projectName flink_study
 * @description: TODO
 * @date 2021/11/217:48
 */
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest tester = new LambdaTest();
        // 类型声明
        MathOperation addition = (int a ,int b)-> a + b;

        //  不用类型声明
        MathOperation subtraction  = ( a , b)-> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = ( a,  b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println(message);
        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

    }



    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
