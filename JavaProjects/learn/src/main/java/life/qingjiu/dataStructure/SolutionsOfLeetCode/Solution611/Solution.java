package main.java.life.qingjiu.dataStructure.SolutionsOfLeetCode.Solution611;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static int triangleNumber(int[] nums){
        //暴力解法
        LinkedList<Triangle> triangles = new LinkedList<>();
        /*
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i]+nums[j] > nums[k] && nums[i]+nums[k] > nums[j] && nums[k]+nums[j] > nums[i] ){
                        triangles.add(new Triangle(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        Iterator<Triangle> it = triangles.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
         */
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                int s = nums[i] + nums[j];
                int l = j + 1, r = nums.length - 1;
                while(l < r){
                    //int mid =
                }
            }
        }

        return triangles.size();
    }
}

class Triangle{
    private int a;
    private int b;
    private int c;
    public Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString(){
        return "["+this.a+","+this.b+","+this.c+"]";
    }

}