#include"utilities.cpp"
#include<iostream>
using namespace std;

void InsertSort(int* arr,int length){
    for(int i=0;i<length;i++){//n轮，循环体内执行n次
        int temp=arr[i];
        int k=i;
        //若是折半查找，确定插入位置时间复杂度O(log_2 n)，但是移动元素的时间复杂度最好O(1)，最差O(n)
        while(temp<arr[k-1] && k>0){
            //确定插入位置，时间复杂度最差O(1),最坏O(n)；
            arr[k]=arr[k-1];
            k--;
        }
        arr[k]=temp;
    }
}

//int main(){
//    int length = 10;
//    int* arr=getRandomArray(length,1,50);
//    printfArray(arr,length);
//
//    InsertSort(arr,length);
//    printfArray(arr,length);
//}
