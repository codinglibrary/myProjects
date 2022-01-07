package dataStructure;

import java.util.ArrayList;

public class Base {
    public static int[] generateRandomIntArray(){
        int n  = (int)(Math.random()*10)+5;//生成一个随机数
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            int temp = (int)(Math.random()*50)+1;
            arr[i] = temp;
        }
        return arr;
    }
}
