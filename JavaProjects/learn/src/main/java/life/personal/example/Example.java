package main.java.life.personal.example;

import java.util.Arrays;

import static main.java.life.qingjiu.dataStructure.utilities.Base.*;

/**
 * @author David
 */
public class Example {
    public static void main(String[] args) {
        int[] a=getRandomIntArr(100,1);
        printArray(a);
        a=getRandomIntArr(10);
        printArray(a);
        int[] b=getRandomIntArr(1);
        printArray(b);
        b=getRandomIntArr(100,1,5);
        printArray(b);
        b=getRandomIntArr(100,1,-2);
        printArray(b);
        b=getRandomIntArr(100,1,-1);
        printArray(b);
        b=getRandomIntArr(100,-9,2);
        printArray(b);
        b=getRandomIntArr(100,2,2);
        printArray(b);
    }
}
