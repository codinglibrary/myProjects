//图的深度优先搜索遍历
#include"utilities.cpp"
using namespace std;

int visit[maxSize]={0};

SqQueue q;int front=0,rear=0;
void DFSMGraph(MGraph* MG,int n){

}
void DFSAGraph(AGraph* AG,int v,int n){//v是起点编号
    if(visit[v]==1)return;//如果当前结点已检查就直接返回
        // cout<<endl;
        // for(int i=0;i<n;i++)cout<<"  ";
        // cout<<"当前检查结点：v["<<v<<"]";
    visit[v]=1;
    q.data[rear++]=v;
        // n+=3;
        // cout<<"=====检查完毕"<<endl;
    ArcNode *p = AG->adjlist[v].firstarc;
        // for(int i=0;i<n;i++)cout<<"  ";
        // if(p!=nullptr){
        //     cout<<"|--下一个检查节点：v["<<p->adjvex<<"]"<<endl;
        // }else{
        //     cout<<"|--开始检查下个结点（事实上是空结点）"<<endl;
        // }
    if(p!=nullptr){
        DFSAGraph(AG,p->adjvex,n);//如果该结点的first弧结点存在就检查
        while( p->nextarc !=nullptr){//如果该结点还有next弧结点继续递归检查
            p=p->nextarc;
            DFSAGraph(AG,p->adjvex,n);
        }
    }
    // while(p!=nullptr){
    //     if(visit[p->adjvex]!=1){
            
    //         DFSAGraph(AG,p->adjvex,n);
    //         p=p->nextarc;
    //         if(p!=nullptr){
    //             for(int i=0;i<n;i++)cout<<"  ";
    //             cout<<"|--检查v"<<v<<"结点的next邻接点:v["<<p->adjvex<<"]"<<endl;
    //         }else{
    //             for(int i=0;i<n;i++)cout<<"  ";
    //             cout<<"|--v"<<v<<"结点所有邻接点检查完毕"<<endl;
    //         }
    //     }else if(p->nextarc && visit[p->nextarc->adjvex]==0){
    //         p=p->nextarc;
    //     }
    //     else{
    //         for(int i=0;i<n;i++)cout<<"  ";
    //         cout<<"|--v"<<v<<"结点的first邻接点"<<"v"<<p->adjvex<<"已经检查完毕"<<endl;
    //         break;
    //     }
    // }
    
}

//int main(){
//    AGraph* AG=getAGraph();
//    DFSAGraph(AG,0,0);
//    cout<<endl<<"遍历顺序为：";
//    while(front!=rear)cout<<"v"<<q.data[front++]<<" ";
//}