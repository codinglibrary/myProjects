/**
 * Copyright (c) qingjiu.life
 */

import example.lists.ListNode;
import example.lists.ListNodeUtils;
import example.utilities.BaseUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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
        int[] res = twoSum(BaseUtils.getRandomIntArr(100,1,100),60);
        logger.debug("---End-----");
        logger.info(Arrays.toString(res));
    }
    private int[] twoSum(int[] nums,int target){
        logger.info(Arrays.toString(nums));
        logger.debug("---Begin---");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{};
    }


    @Test
    public void test(){

    }

}
