#include"utilities.cpp"
#include<iostream>
using namespace std;

void SimpleSelectSort(int* arr,int length){
    int k,temp;
    for(int i=0;i<length;i++){
        int k=i;
        for(int j=i+1;j<length;j++)
            if(arr[k]>arr[j])k=j;//找到最小的元素
        temp=arr[k];
        arr[k]=arr[i];
        arr[i]=temp;
    }
}

int main(){
    int length = 10;
    int* arr=getRandomArray(length,2,100);
    printfArray(arr,length);
    cout<<"=====Begin sort====="<<endl;
    SimpleSelectSort(arr,length);
    cout<<"=======End sort====="<<endl;
    printfArray(arr,length);
}

