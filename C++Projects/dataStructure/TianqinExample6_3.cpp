#include<iostream>
#include"utilities.cpp"
using namespace std;

BTNode* getNodeOfKey(BTNode *root, Element key){
	if(root==nullptr)return nullptr;
	else{
		if(root->data == key)return root;
		BTNode *lc=getNodeOfKey(root->lchild,key);
		if(lc != nullptr)return lc;
		BTNode *rc=getNodeOfKey(root->rchild,key);
		if(rc!=nullptr)return rc;
	}
	return nullptr;
}

//int main(void){
//    BTNode* T = getTree();
//    BTNode *temp=getNodeOfKey(T,3);
//    if(temp->lchild!=nullptr){
//        BTNode *t = temp->lchild;
//        cout<<t->data;
//    }
//    else if(temp!=nullptr)cout<<"Not found its lchild !"<<endl;
//    else cout<<"Not found the Node"<<endl;
//    return 1;
//}