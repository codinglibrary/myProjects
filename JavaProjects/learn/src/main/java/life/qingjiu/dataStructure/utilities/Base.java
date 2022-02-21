package main.java.com.qingjiu.dataStructure.utilities;

public class Base {
    private static int[] randomArr;

    private static void generateRandomIntArray(){
        int n  = (int)(Math.random()*10)+5;//生成一个随机数
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            int temp = (int)(Math.random()*50)+1;
            arr[i] = temp;
        }
        Base.randomArr = arr;
    }

    public static int[] getRandomArr(){
        generateRandomIntArray();
        return Base.randomArr;
    }

}
