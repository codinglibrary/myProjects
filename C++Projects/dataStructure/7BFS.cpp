//图的广度优先搜索遍历
#include"utilities.cpp"
using namespace std;

int visit[maxSize]={0};
int q_res[maxSize];int f_res=0,r_res=0;

void BFSAGraph(AGraph* AG,int v){
    int queue[maxSize];int front=0,rear=0;
    visit[v]=1;
    rear=(rear+1)%maxSize;
    queue[rear]=v;
}