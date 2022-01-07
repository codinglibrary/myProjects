#ifndef __DEFINATIONOFDATASTRUCTURE_H
#define __DEFINATIONOFDATASTRUCTURE_H
//自定义区
#define maxSize 100 //顺序表大小,顺序栈大小,顺序队列大小
typedef int Element;


/*线性表*/

//顺序表结构体
typedef struct
{
    Element data[maxSize];
    int length;
}Sqlist;
//单链表结点
typedef struct LNode
{
    Element data;
    struct LNode *next;
}LNode;
//双链表结点定义
typedef struct DLNode{
    Element data;
    struct DLNode *prior;
    struct DLNode *next;
}DLNode;


/*栈和队列*/

//顺序栈
typedef struct{
    Element data[maxSize];
    int top;
}SqStack;
//链栈结点
    /*和链表结点一样*/
    
//顺序队列结点
typedef struct{
    Element data[maxSize];
    int front;
    int rear;
}SqQueue;
//链队
//队结点类型
typedef struct QNode{
    Element data;
    struct QNode *next;
}QNode;
//链队类型
typedef struct{
    QNode *front;
    QNode *rear;
}QNode_2;


/*串*/

//定长顺序存储
typedef struct{
    char str[maxSize+1];
    int length;
}SString;
//变长分配存储
typedef struct{
    char *str;
    int length;
}HString;
//链式存储——单结点单字符
typedef struct StringNode{
    char ch;//每个结点存1个字符,存储密度低，每个字符1B，每个指针4B
    struct StringNode *next;
}StringNode,*String;
//链式存储——单结点多字符
typedef struct SNode{
    char ch[4];//每个结点存多个个字符,存储密度提高，每个字符1B，每个指针4B
    struct StringNode *next;
}SNode;


/*树*/
//树的孩子表示法和图的邻接表相似。
//树的孩子兄弟表示法主要用于树和二叉树的相互转换
//二叉树的链式存储
typedef struct BTNode{
    Element data;//数据域
    struct BTNode *lchild;
    struct BTNode *rchild; 
}BTNode;

/*图*/
//邻接矩阵
typedef struct {
    int no;//顶点编号
    char info;//其他信息，不做要求可以不写
}VertexType;//顶点类型
typedef struct{//图的定义
    int edges[maxSize][maxSize];//矩阵,有权图需要用float
    int n,e;//边和顶点的个数
    VertexType vex[maxSize];//存放结点信息
}MGraph;
//邻接表
typedef struct ArcNode{
    int adjvex;//该边所指向的结点的位置
    struct ArcNode* nextarc;//指向下一条边的指针
    int info;//该边的相关信息（如权值）
    ArcNode(int adjvex,ArcNode* nextarc):adjvex(adjvex),nextarc(nextarc){this->info=0;}
}ArcNode;
typedef struct {
    char data;//顶点信息
    ArcNode* firstarc;//指向第一条边的指针
}VNode;
typedef struct{
    VNode adjlist[maxSize];
    int n,e;
}AGraph;//邻接表
//邻接多重表

#endif
