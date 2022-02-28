#include<iostream>
#include"utilities.cpp"
using namespace std;

void level(BTNode* root){
    int front,rear;
    front=0;rear=0;
    BTNode* queue[maxSize];
    if(root!=nullptr){
        queue[rear++]=root;
        BTNode* temp;
        while(front!=rear){
            temp=queue[front++];
            if(temp->lchild!=nullptr)queue[rear++]=temp->lchild;
            if(temp->rchild!=nullptr)queue[rear++]=temp->rchild;
            cout<<temp->data<<" ";
        }
    }
}


//int main(void){
//    BTNode *T=getTree();
//    level(T);
//    return 1;
//}