package SolutionsOfLeetCode.Solution743;

public class Instance {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4,k = 2;
        int[][] times2 = {{1,2,1}};
        int n2 = 2, k2 = 1;
        System.out.println(Solution.networkDelayTime(times, n, k));
    }
}
