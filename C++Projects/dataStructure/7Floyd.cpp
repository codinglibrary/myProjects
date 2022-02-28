#include"utilities.cpp"
#include<iostream>
using namespace std;

void Floyd(MGraph* MG,int Path[][maxSize],int A[][maxSize]){
    //初始化两个数组：Path，A
    for(int i=0;i<MG->n;i++){
        for(int j=0;j<MG->n;j++){
            A[i][j]=MG->edges[i][j];
            Path[i][j]=-1;
        }
    }
    //以k为中间点对所有顶点检测和修改
    
}

//输出从u到v的最短路径上的结点序列
void printfPath(int u,int v,int path[][maxSize],int A[][maxSize]){
    if(A[u][v]==INFTY)cout<<"不可达！"<<endl;
    else{
        if(path[u][v]==-1)cout<<"<"<<u<<","<<v<<"> ";
        else{
            int mid=path[u][v];
            printfPath(u,mid,path,A);
            printfPath(mid,v,path,A);
        }
    }
}

//int main(){
//    int A[maxSize][maxSize],Path[maxSize][maxSize];
//    Floyd(getMGraph(),Path,A);
//    printfPath(0,6,Path,A);
//}