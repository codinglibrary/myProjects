/**
 *有 n 个网络节点，标记为1到 n。
 * 给你一个列表times，表示信号经过有向边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1。
 */
package main.java.life.qingjiu.dataStructure.SolutionsOfLeetCode.Solution743;

import java.util.Arrays;

//题目实际是求节点 K 到其他所有点中最远的距离，那么首先需要求出节点 K 到其他所有点的最短路径，然后取最大值即可。
public class Solution {
    public static int networkDelayTime(int[][] times, int n, int k) {
//      Dijkstra算法。贪心思想
        final int INF = Integer.MAX_VALUE/2;

        //dist[]数组存储从源点到节点的距离
        int[] dist = new int[n];
        Arrays.fill(dist,INF);
        dist[k-1] = 0;

        //使用邻接矩阵表示图
        int[][] graphic = new int[n][n];
            //先初始化图
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                graphic[i][j] = INF;
            //将节点间的距离映射到graphic数组
        for(int[] t : times)
            graphic[t[0]-1][t[1]-1] = t[2];

        boolean[] used = new boolean[n];
        //执行dijkstra思想算法
        for(int i = 0; i < n; i++){//将n个点加入到used集合
            int x = -1;
            for(int j = 0; j < n; j++)
                if(!used[j] && (x == -1 || dist[j] < dist[x]))
                    x = j;
            used[x] = true;
            for(int j = 0; j < n; j++)
                dist[j] = Math.min(dist[j], dist[x] + graphic[x][j]);
        }

        //在最短路径中找到距离最远的点
        int res = Arrays.stream(dist).max().getAsInt();
        return res == INF ? -1 : res;
    }
}
