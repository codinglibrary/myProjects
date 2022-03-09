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

    public static void binaryInsertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int j = i;
            int num = nums[j];
            int left = 0,right = i-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(num >= nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            for(j=i;j>right+1;j--){
                nums[j]=nums[j-1];
            }
            nums[right+1] = num;
        }
    }

    public static void selectSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int min = nums[i];
            int index = i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<min){
                    min = nums[j];
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void mergeSort(int[] nums,int left,int right){
        int mid = (left+right)/2;
        if(left<right){
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
        }
        merge(nums,left,mid,right);
    }
    private static void merge(int[] nums,int left,int mid,int right){
        if(left<right){
            int[] tempArr = new int[nums.length];
            for(int i=left;i<=right;i++){
                tempArr[i]=nums[i];
            }
            int p=left,q=mid+1,t=left;
            while(p<=mid && q<=right) {
                if (tempArr[p] <= tempArr[q]) {
                    nums[t++] = tempArr[p++];
                }else{
                    nums[t++] = tempArr[q++];
                }
            }
            while(p<=mid){
                nums[t++]=tempArr[p++];
            }
            while(q<=right){
                nums[t++]=tempArr[q++];
            }
        }
    }
}
