#include"utilities.cpp"
#include<iostream>
using namespace std;


void Prim(MGraph* MG,int v,int& sum){//邻接矩阵，起点，树的权值
    int lowcost[MG->n];
    int vset[MG->n]; 
    
    for(int i=0;i<MG->n;i++){
        lowcost[i]=MG->edges[v][i];
        vset[i]=0;
    }
    vset[v]=1;
    sum=0;
    int k=-1;
    for(int j=0;j<MG->n-1;j++){//注意这里是n-1，v号元素已经加入到vset，剩下n-1个。
    //循环的次数并不表示遍历0到n-1号元素，而是找到n-1个最小值依次加入vset
        int min=INFTY;
        for(int i=0;i<MG->n;i++){
            if(vset[i]==0 && lowcost[i]<min){
                min=lowcost[i];
                k=i;
            }
        }
        
        vset[k]=1;
        sum+=min;
        for(int i=0;i<MG->n;i++){
            if(vset[i]==0 && MG->edges[k][i] < lowcost[i])
                lowcost[i]=MG->edges[k][i];
        }
    }
}

int main(){
    int sum;
    MGraph* MG=getMGraph();
    Prim(MG,0,sum);
    cout<<sum;
    return 1;
}
