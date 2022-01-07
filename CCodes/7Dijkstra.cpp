#include"utilities.cpp"
#include<iostream>
using namespace std;

//求v到其他各点的最短路径，存储在path和dist中
void Dijkstra(MGraph MG,int v,int dist[],int path[]){
    //对三个数组(dist,path,set)初始化
    int set[MG.n];
    for(int i=0;i<MG.n;i++){
        dist[i]=MG.edges[v][i];
        set[i]=0;
        if(MG.edges[v][i]<INFTY)path[i]=v;
        else path[i]=-1;
    }
    set[v]=1;path[v]=-1;

    for(int i=0;i<MG.n-1;i++){//操作每一个结点
        int min=INFTY;
        int k;
        for(int j=0;j<MG.n;j++){//找到集合外离v最远的结点
            if(set[j]==0 && dist[j]<min){
                k=j;
                min=dist[j];
            }
        }
        set[k]=1;
        //并入新结点后更新dist和path
        for(int j=0;j<MG.n;j++){
            if(set[j]==0 && dist[k]+MG.edges[k][j] < dist[j]){
                dist[j] = dist[k] + MG.edges[k][j];
                path[j]=k;
            }
        }
    }
}
void printfPath(int path[],int a){
    int stack[maxSize], top=-1;
    while(path[a]!=-1){//生成path时，第一个结点(即v)的path[v]=-1
        stack[++top]=a;
        a=path[a];
    }
    stack[++top]=a;
    while(top!=-1)
        cout<<stack[top--]<<" ";
    cout<<endl;
}

int main(){
    MGraph* MG=getMGraph();

    int dist[MG->n];
    int path[MG->n];

    Dijkstra(*MG,0,dist,path);
    printfPath(path,6);
}