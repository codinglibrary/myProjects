#include<iostream>
#include"header/definitionOfDataStructure.h"
//#define maxSize 100
using namespace std;

typedef int Element;
typedef struct Node{ 
    Element data;
    Node* next;
}Node;

void setStr(HString& str,char* text){
    int len = 0;
    char* ch = text;
    while(*ch){
        ++len;
        ++ch;
    }
    str.str = (char*)malloc(sizeof(char)*(len+1));
    str.length=len;
    for(int i=0;i<len+1;i++){
        str.str[i]=text[i];
    }
}

int SimplePattern(HString text , HString pattern){
    int i=0,j=0,k=i;
    while(i < text.length && j<pattern.length){
        if(text.str[i]==pattern.str[j]){
            ++i;
            ++j;
        }else{
            j=1;
            i=++k;
        }
    }
    if(j>=pattern.length)return k;
    else return -1;
}

//int main(void){
//    HString text,pattern;
//    setStr(text,"Hello,My name is Liang Han.I'm from China.");
//    setStr(pattern,"Liang Han");
//
//    cout<<SimplePattern(text,pattern)<<endl;
//}
//


//head指向单链表第一个结点
Element searchLastKth(Node* head,int k){
    Node* fast = head;
    while(fast->next == nullptr || --k) fast=fast->next;
    if(fast->next == nullptr ) return 0;
    Node* slow = head;
    while(fast->next != nullptr){//fast指向最后一个结点
        fast = fast->next;
        slow = slow->next;
    }
    cout<<slow->data;
    return 1;
}