/**
 * Copyright (c) qingjiu.life
 */

import example.utilities.Base;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * java 数据结构
 *
 * @author David
 * @since 2022/03/07 16:19
 */
public class LeetCodeTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void twoSumTest(){
        int[] res = twoSum(Base.getRandomIntArr(100,1,100),60);
        logger.info("---End-----");
        logger.info(Arrays.toString(res));
    }
    private int[] twoSum(int[] nums,int target){
        logger.info(Arrays.toString(nums));
        logger.info("---Begin---");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(target == nums[i]+nums[j]){
//                    return new int[]{i,j};
//                }
//            }
//        }
        return new int[]{};
    }
    @Test
    public void threeSumTest(){
        List<List<Integer>> lists = threeSum(Base.getRandomIntArr(100,1,2000));
        logger.info("---End-----");
        logger.info(lists.toString());
    }
    private List<List<Integer>> threeSum(int[] nums){
        logger.info(Arrays.toString(nums));
        logger.info("---Begin---");
        //暴力
        List<List<Integer>> lists = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            for (int j = 0;j<nums.length;j++){
                for(int k = 0;k<nums.length;k++){
                    if(0== nums[i]+nums[j]+nums[k]){
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }
}
