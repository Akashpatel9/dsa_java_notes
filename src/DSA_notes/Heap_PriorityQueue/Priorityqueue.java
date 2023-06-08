package DSA_notes.Heap_PriorityQueue;

import java.util.ArrayList;

public class Priorityqueue {
    static ArrayList<Integer> heap = new ArrayList<>();

    public void push(int n){
        heap.add(n);
        
        int childNode = heap.size()-1;
        int parentNode = (childNode-1)/2;

        while(heap.get(childNode) < heap.get(parentNode)){
            swap(parentNode,childNode);
            childNode=parentNode;
            parentNode=(childNode-1)/2;
        }
    }

    public Integer poll(){
        if (isEmpty()) return null;

        int val = heap.get(0);

        swap(0,heap.size()-1);
        heap.remove(heap.size()-1);
        heapify(0);
        return val;
    }

    public void heapify(int parentNode){

        int leftChildNode = parentNode*2+1;
        int rightChildNode = parentNode*2+2;
        int minIdx = parentNode;

        if (leftChildNode<heap.size() && heap.get(leftChildNode)<heap.get(minIdx)) minIdx=leftChildNode;
        if (rightChildNode<heap.size() && heap.get(rightChildNode)<heap.get(minIdx)) minIdx=rightChildNode;

        if (minIdx!=parentNode){
            swap(minIdx,parentNode);
            heapify(minIdx);
        }
    }
    
    public Integer peek(){
        if (heap.isEmpty())return null;
        return heap.get(0);
    }
    
    public boolean isEmpty(){
        return heap.size()==0;
    }

    public void swap(int i, int j){
        int tem = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,tem);
    }
    public static void main(String[] args) {
        int[] arr = {4,2,5,7,3,8,10};
        //      2
        //     / \
        //   3    5
        //  /\    /\
        // 7  4  8  10

        Priorityqueue pq = new Priorityqueue();

        for (int e : arr) {
            pq.push(e);
        }
        while (!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
    }
}
