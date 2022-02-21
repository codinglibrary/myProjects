package main.java.com.qingjiu.dataStructure.SolutionsOfLeetCode.Solution1;

import java.util.HashMap;

public class Solution {
    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        //暴力解法
        /*
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if( nums[i] + nums[j] == target ){
                    //return new int[]{i,j};
                    res[0] = i;
                    res[1] = j;
                    System.out.println("Find it!");
                }
            }
        }
        */

        //时间最优解法，以空间换时间
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey( target - nums[i] ) )
                return new int[]{ map.get(target - nums[i]) , i};
            map.put(nums[i],i);
        }
        return res;
    }
}
