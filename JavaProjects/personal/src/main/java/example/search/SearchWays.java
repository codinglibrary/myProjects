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
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void quickSort(int[] nums,int left,int right) {
        if(left<right){
            int pivot = sort(nums,left,right);
            quickSort(nums,left,pivot-1);
            quickSort(nums,pivot+1,right);
        }
    }

    private static int sort(int[] nums,int left,int right){
        int point = nums[left];
        int i=left,j=right;
        while(i<j){
            while( nums[j]>point && j>i){
                j--;
            }
            if(j>i){
                nums[i]=nums[j];
                i++;
            }
            while( nums[i]<point && i<j){
                i++;
            }
            if(i<j){
                nums[j]=nums[i];
                j--;
            }
        }
        nums[i] = point;
        return i;
    }

}
