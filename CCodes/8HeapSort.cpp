#include"utilities.cpp"
#include<iostream>
using namespace std;

//从left向下调整堆,将最大值调整到left的位置
void Sift(int* arr,int left,int right){
    int i=left,j=2*left;//Attention！！！,如果left是0,那么j也是0
    int temp=arr[i];
    while(j <= right){
        if(i<right && arr[j]<arr[j+1] && j+1<right)j++;//默认指向左孩子，若右孩子较大则指向右孩子
        if(temp<arr[j]){//
            arr[i]=arr[j];//将孩子的值放到父结点上
            i=j;j=2*j;//从孩子结点开始，继续调整
        }else break;//没有调整孩子结点，结束调整堆
    }arr[i]=temp;//将父结点的值放到最终位置
    printfArray(arr,1,10);
}

//堆排序
void HeapSort(int* arr ,int n){
    int temp;
    for(int i=n/2;i>=1;--i){//建立初始堆,由从倒数第一个分支结点依次向上调整
        Sift(arr,i,n);
    }
    printfArray(arr,1,n);//此处最大值已在堆根
    cout<<"大根堆已生成，开始排序"<<endl;
    for(int i=n;i>=2;){//
        temp=arr[1];
        arr[1]=arr[i];
        arr[i]=temp;
        cout<<"第"<<i<<"个位置:"<<arr[i]<<" 已调整完毕："<<", 剩下未调整：";
        printfArray(arr,1,i-1);
        cout<<endl;
        Sift(arr,1,--i);
    }
}

int main(){
    int length = 11;//arr 0~10 共11个数
    int* arr=getRandomArray(length,1,100);
    arr[0]=-1;int n=length-1;//n为10
    printfArray(arr,1,n);//传入下标为1~10
    cout<<"=====Begin sort====="<<endl;
    HeapSort(arr,n);
    cout<<"=======End sort====="<<endl;
    printfArray(arr,1,n);
}

