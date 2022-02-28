#include"utilities.cpp"
#include<iostream>
using namespace std;

void QuickSort(int* arr,int left,int right,int n){
    if(left>=right)return;
    int pivot=arr[left];
    int i=left,j=right;
    while(i<j){
        while(arr[j]>=pivot && i<j)j--;
        if(i<j){
            arr[i]=arr[j];
            i++;
        }
        while(arr[i]<=pivot && i<j)i++;
        if(i<j){
            arr[j]=arr[i];
            j--;
        } 
    }
    arr[j]=pivot;
    QuickSort(arr,left,i-1,n);n-=3;
    QuickSort(arr,i+1,right,n);
}

int main(){
    int length = 50;
    int* arr=getRandomArray(length,1,40);
    printfArray(arr,length);
    cout<<"=====Begin sort====="<<endl;
    QuickSort(arr,0,length-1,0);
    cout<<"=======End sort====="<<endl;
    printfArray(arr,length);
}

