#include<iostream>
#include"utilities.cpp"
using namespace std;

int getDepth(BTNode *root){
    if(root == nullptr)return 0;
    else{
        int depth_lchild = getDepth(root->lchild);
        int depth_rchild = getDepth(root->rchild);
        return (depth_lchild>depth_rchild?depth_lchild:depth_rchild)+1;
    }   
}

//int main(void){
//    BTNode *T=getTree();
//    cout<<getDepth(T);
//    return 1;
//}