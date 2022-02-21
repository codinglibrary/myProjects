package main.java.life.qingjiu.dataStructure.SolutionsOfLeetCode.Solution1;

import java.util.Arrays;

public class Instance {
    public static void main(String[] args) {
        int[][] nums = {{2,7,11,15},{3,2,4},{3,3}};
        int[] target = {9,6,6};
        for(int i = 0; i < nums.length; i++){
            System.out.println(Arrays.toString(Solution.twoSum(nums[i],target[i])));
        }
    }
}
