package DSA_notes.Heap_PriorityQueue;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int []arr){ //O(n*logN)
        // create maxHeap
        for (int i = arr.length/2; i >=0 ; i--) {
            heapify(arr,i, arr.length);
        }

        // short
        for (int i = arr.length-1; i>0; i--) {
            swap(arr, i, 0);
            heapify(arr,0,i);
        }
    }

    public static void heapify(int [] arr , int i , int size){
        int leftChild = i*2+1;
        int rightChild = i*2+2;
        int idx = i;
        if (leftChild<size && arr[leftChild]>arr[idx]) idx=leftChild;
        if (rightChild<size && arr[rightChild]>arr[idx]) idx=rightChild;
        if (i!=idx){
            swap(arr,idx,i);
            heapify(arr,idx,size);
        }
    }

    public static void swap(int []arr , int i , int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
    public static void main(String[] args) {
        int []arr ={5,2,8,7,3,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
