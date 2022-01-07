#include"utilities.cpp"
#include<iostream>
using namespace std;


void BubbleSort(int* arr,int length){
    bool theTripIsOkFlag=false;int temp;
    for(int i=0;i<length;i++){
        theTripIsOkFlag=false;
        for(int j=length-1;j>i;j--){
            if(arr[j]<arr[j-1]){
                temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                theTripIsOkFlag=true;
            }
        }
        printfArray(arr,length);
        if(theTripIsOkFlag==false)return;//本趟没有发生交换，排序结束
    }
}

int main(void){
    int length = 10;
    int* arr=getRandomArray(length,1,50);
    printfArray(arr,length);
    cout<<"开始排序"<<endl;
    BubbleSort(arr,length);
    //printfArray(arr,length);
}
