/**
 * Copyright (c) qingjiu.life
 */
package example.sort;

/**
 * 各种排序方法
 *
 * @author David
 * @since 2022/03/09 18:39
 */
public class SortWays {

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

    public static void insertSort(int[] nums){
        for(int i = 1;i<nums.length;i++){
            int j = i;
            while(j > 0 && nums[j]<nums[j-1] ){
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }

}
