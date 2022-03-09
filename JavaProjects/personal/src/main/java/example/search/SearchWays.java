/**
 * Copyright (c) qingjiu.life
 */
package example.search;

/**
 * 二分查找
 *
 * @author David
 * @since 2022/03/08 17:45
 */
public class SearchWays {
    /**
     * @return the index of the target in a sorted list.
     * @since 2022/03/08 17:49
     */
    public static int binarySearch(int[] nums, int target) throws Exception {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int the = nums[mid];
            if (the < target) {
                left = mid + 1;
            } else if (the > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            throw new Exception("该数组中不存在此值");
        }
    }
}
