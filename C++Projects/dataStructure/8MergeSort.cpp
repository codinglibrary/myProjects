/**
 * 
 * 伪代码
 * void MergeSort(int* arr,int left,int right){
 *      if(left<high){
 *          int mid=(left+right)/2;
 *          MergeSort(arr,left,mid);
 *          MergeSort(arr,mid+1,right);
 *          merge(arr,left,mid,right);//合并算法需要辅助空间 O(n)
 *      }
 * }
 * */