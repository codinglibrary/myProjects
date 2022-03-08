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
    public void testLengthOfLongestSubstring(){
        String s =" ";

        logger.debug(String.valueOf(lengthOfLongestSubstring(s)));
    }
    private int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = 0 ,ans =0;
        for(int i = 0; i < n; i++){
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while( rk<n && !set.contains(s.charAt(rk))){
                set.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans,rk-i);
        }
        return ans;
    }

    @Test
    public void testFindMedianSortedArrays(){
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4,6};
        logger.info(String.valueOf(findMedianSortedArrays(a,b)));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }


}
