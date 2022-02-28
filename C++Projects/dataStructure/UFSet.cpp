/**

#include<iostream>
using namespace std;

#define SIZE 13

int UFSets[SIZE];
typedef struct{
    int data;
    element* parent;
}element,Set;

//初始化并查集
void Initial(Set* ufs){
    ufs->data=0;
    ufs->parent=ufs;

    element *a,*b,*c;
    a->parent=ufs;
    a->data=1;

    b->data=2;
    b->parent=ufs;

    c->data=3;
    c->parent=b;
}

//"查",O(n)
int Find(Set* e,int x){
    if(e->parent = )return ;
    else{

    }
    while(S[x]>0){
        x=S[x];
    }
    return x;
}

//"并",O(1)
void Union(int S[],int root1,int root2){
    if(root1!=root2){
        S[root2]=S[root1];
    }
}

int main(void){

    return 1;
}

 */