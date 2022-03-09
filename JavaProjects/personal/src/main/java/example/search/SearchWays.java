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

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = sort(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private static int sort(int[] nums, int left, int right) {
        int point = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > point) {
                --j;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < point) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = point;
        return i;
    }

    public static void bubbleSort(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            int j=nums.length-1;
            while(j>i){
                if(nums[j]<nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
                j--;
            }
        }
    }
}
