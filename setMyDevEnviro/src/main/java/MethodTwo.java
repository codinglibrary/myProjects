package main.java;

import java.util.Map;

public class MethodTwo {
    public static void main(String[] args) {
        Map map = System.getenv();
        String s = System.getenv("AA");
        System.out.println(s);
    }
}
