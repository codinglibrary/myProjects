#include"header/utilities.h"
#define INFTY 65535//infinite，infinity
using namespace std;

/*
         1
       /   \
      2     3   
     / \   / \
    4   5 6   7      
*/
BTNode * getTree(){
    BTNode *T =new BTNode();
    BTNode *Tlc=new BTNode();
    BTNode *Trc=new BTNode();
    BTNode *Tlclc=new BTNode();
    BTNode *Tlcrc=new BTNode();
    BTNode *Trclc=new BTNode();
    BTNode *Trcrc=new BTNode();

    T->data = 1;
    Tlc->data = 2;
    Trc->data = 3;
    Tlclc->data = 4;
    Tlcrc->data = 5;
    Trclc->data=6;
    Trcrc->data=7;
    
    T->lchild = Tlc;
    T->rchild = Trc;
    Tlc->lchild = Tlclc;
    Tlc->rchild = Tlcrc;
    Trc->lchild = Trclc;
    Trc->rchild = Trcrc;
    Tlclc->lchild = nullptr;
    Tlclc->rchild = nullptr;
    Tlcrc->lchild = nullptr;
    Tlcrc->rchild = nullptr;
    Trclc->lchild = nullptr;
    Trclc->rchild = nullptr;
    Trcrc->lchild = nullptr;
    Trcrc->rchild = nullptr;

    return T;
}

/*
 
*/
MGraph* getMGraph(){
    MGraph* G=new MGraph();
    VertexType v0;
    v0.no=0;
    v0.info='a';
    VertexType v1;
    v1.no=1;
    v1.info='b';
    VertexType v2;
    v2.no=2;
    v2.info='c';
    VertexType v3;
    v3.no=3;
    v3.info='d';
    VertexType v4;
    v4.no=4;
    v4.info='e';
    VertexType v5;
    v5.no=5;
    v5.info='f';
    VertexType v6;
    v6.no=6;
    v6.info='g';

    G->vex[0]=v0;
    G->vex[1]=v1;
    G->vex[2]=v2;
    G->vex[3]=v3;
    G->vex[4]=v4;
    G->vex[5]=v5;
    G->vex[6]=v6;

    G->edges[0][1]=1;
    G->edges[1][3]=2;
    G->edges[0][2]=2;
    G->edges[0][3]=1;
    G->edges[2][3]=1;
    G->edges[3][5]=3;
    G->edges[3][4]=1;
    G->edges[2][4]=1;
    G->edges[2][5]=1;
    G->edges[4][6]=2;
    G->edges[6][5]=4;
    
    G->n=7;
    G->e=8;
    for(int i=0;i < G->n;i++){
        for(int j=0;j<G->n;j++){
            if(G->edges[i][j]==0)G->edges[i][j]=INFTY;
        }
    }
    for(int i=0;i<G->n;i++)G->edges[i][i]=1;

    return G;
}

/*
    
*/
AGraph* getAGraph(){
    AGraph* G=new AGraph();

    VNode v0;
    v0.data='a';
    v0.firstarc=nullptr;
    VNode v1;
    v1.data='b';
    v1.firstarc=nullptr;
    VNode v2;
    v2.data='c';
    v2.firstarc=nullptr;
    VNode v3;
    v3.data='d';
    v3.firstarc=nullptr;
    VNode v4;
    v4.data='d';
    v4.firstarc=nullptr;
    VNode v5;
    v5.data='f';
    v5.firstarc=nullptr;
    VNode v6;
    v6.data='g';
    v6.firstarc=nullptr;
    

    v0.firstarc=new ArcNode(1,
                new ArcNode(2,nullptr));
    v1.firstarc=new ArcNode(3,nullptr);
    v3.firstarc=new ArcNode(1,
                new ArcNode(4,nullptr));
    v4.firstarc=new ArcNode(5,
                new ArcNode(6,nullptr));
    v6.firstarc=new ArcNode(5,nullptr);
    
    G->adjlist[0]=v0;
    G->adjlist[1]=v1;
    G->adjlist[2]=v2;
    G->adjlist[3]=v3;
    G->adjlist[4]=v4;
    G->adjlist[5]=v5;
    G->adjlist[6]=v6;
    return G;

}
int* getRandomArray(int length,int minOfNumber,int maxOfNumber){//返回 min <= x <= max 输入数组长度、数的下限值和数的上限值
    int* arr=new int[length];
    for(int i=0;i<length;i++){
        arr[i]=rand()%(maxOfNumber-minOfNumber+1)+minOfNumber;
    }
    return arr;
}
int* getRandomArray(int length,int maxOfNumber){//输入数组长度和数的上限值,下限值默认0
    return getRandomArray(length,1,maxOfNumber);
}
int* getRandomArray(int length){//输入数组长度,默认范围1~20
    return getRandomArray(length,20);
}

void printfArray(int* arr,int left,int right){
    if(left>right){
        cout<<"null"<<endl;
        return;
    }
    for(int i=left;i<=right;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

void printfArray(int* arr,int length){
    for(int i=0;i<length;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}


