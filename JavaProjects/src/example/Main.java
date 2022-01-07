package example;

import java.io.Serializable;
import java.security.KeyStore;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        test3();
    }

    //Lambda表达式
    static void test1(){
        LambdaExample<Integer> example = new LambdaExample<>();

        example.eat(()-> System.out.println("辣椒酱好吃"));
        example.drive(weather -> {
            // 对接口中抽象方法 fly 的重写
            System.out.println("今天天气是：" + weather);
            System.out.println("飞机平稳飞行！");
        });
        // Lambda 表达式只有一条语句，即使该表达式需要返回值，也可以省略 return
/*
        example.calc((a, b) -> a + b);
*/
        // 如果不用 Lambda 表达式，就需要如下匿名类的方式去重写抽象方法
/*
        example.calc(new Addable() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        });
*/
    }

    //实现Comparable接口
    static void test2() throws InterruptedException {
        LearningBook spring1 = new LearningBook("Spring2",16,"Spring");
        Thread.sleep(1);
        LearningBook spring2 = new LearningBook("Spring8",12,"Spring");
        spring1.compareTo(spring2);
    }

    //线性表、栈、队列、优先队列
    static void test3(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        for (Integer i = 2; i < 6; i++) {
            a.add(i);
        }
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        arrayList.remove(0);
        System.out.println(arrayList.size());
        System.out.println(arrayList.toString());
        System.out.println(arrayList.containsAll(a));
        arrayList.retainAll(a);
        System.out.println(arrayList.toString());
        arrayList.stream();
    }
}
