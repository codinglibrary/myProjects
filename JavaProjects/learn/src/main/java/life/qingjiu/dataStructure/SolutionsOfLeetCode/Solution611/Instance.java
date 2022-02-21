package main.java.life.qingjiu.dataStructure.SolutionsOfLeetCode.Solution611;

public class Instance {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{9,5,8,12},{3,2,2,4}};
        for(int i = 0; i < nums.length; i++){
            System.out.println(Solution.triangleNumber(nums[i]));
        }
    }
}
