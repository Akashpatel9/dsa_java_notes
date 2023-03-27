package DSA_notes.LinkedList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class LinkedList {
    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public int size;



    //insert first;
    public void add_first(int val) {
        Node newNode = new Node(val);
        size++;
        if (head == null) {
            tail = newNode;
            head = tail;
            return;
        }
        newNode.next = head;
        head = newNode;
    }



    // insert last
    public void add_last(int val) {
        Node newNode = new Node(val);
        size++;
        if (head == null) {
            tail = newNode;
            head = tail;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }


    // print list
    public void print_list() {
        if (head == null) {
            System.out.println("list is empity");
            return;
        }
        Node tem = head;

        while (tem != null) {
            System.out.print(tem.val + " ");
            tem = tem.next;
        }
        System.out.println();
    }



    // insert at position
    public void add(int ind, int val) {
        if (ind == 0) {
            add_first(val);
            return;
        }
        Node newNode = new Node(val);
        size++;
        int c = 0;
        Node temp = head;
        while (c < ind - 1) {
            temp = temp.next;
            c++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }



    //remove first
    public int remove_first() {
        if (head == null) {
            System.out.println("LinkList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.val;
            head = tail = null;
            size = 0;
            return data;
        }
        size--;
        int data = head.val;
        head = head.next;
        return data;
    }



    //remove last
    public int remove_last() {
        if (head == null) {
            System.out.println("LinkList is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int data = tail.val;
            head = tail = null;
            size = 0;
            return data;
        }

        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        size--;
        int val = temp.next.val;
        temp.next = null;
        tail = temp;
        return val;
    }



    //remove idx element
    public int remove(int ind) {
        if (size == 0 || ind >= size || ind < 0) {
            System.out.println("Index out of bound");
            return Integer.MIN_VALUE;
        } else if (ind == 0) {
            int val = head.val;
            remove_first();
            return val;
        }
        else if(ind==size-1){
            remove_last();
            return tail.val;
        }
        Node tem = head;
        for (int i = 0; i < ind - 1; i++) {
            tem = tem.next;
        }
        int val = tem.next.val;
        tem.next = tem.next.next;
        size--;
        return val;
    }



    //search in LinkList Iterative
    public int Iterative_search(int val) {
        Node tem = head;
        for (int i = 0; i < size; i++) {
            if (tem.val == val) {
                return i;
            }
            tem = tem.next;
        }
        return -1;
    }



    //search in Linklist recursive
    public int helper(Node head, int value) {
        if (head == null) {
            return -1;
        }

        if (head.val == value) {
            return 0;
        }

        int idx = helper(head.next, value);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursive_search(int val) {
        return helper(head, val);
    }



    //revers linklist
    public void reverse(){
        if(head==null){
            System.out.println("Empity linklist");
            return;
        }
        else if (size==1){
            return;
        }
        Node pre = null;
        Node curr = tail=head;
        Node next;
        while (curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
       head = pre;
    }



    //delete nth node
    public int remove_nth(int ind) {
        if (size==0 || ind<0 || ind>=size){
            System.out.println("invalid index");
            return Integer.MAX_VALUE;
        }
        else if (ind==0){
            int val = head.val;
            remove_first();
            return val;
        }else if (ind==size-1){
            int val=tail.val;
            remove_last();
            return val;
        }
        Node tem = head;
        for (int i = 0; i < ind-1; i++) {
            tem=tem.next;
        }
        int val = tem.next.val;
        tem.next=tem.next.next;
        size--;
        return val;
    }

    //delete nth node from last;
    public int remove_last_nth(int ind){
        if(head==null){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if (ind<0 || size<=ind){
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }
        else if (ind==size-1){
            int val = head.val;
            remove_first();
            return val;
        } else if (ind==0) {
            int val = tail.val;
            remove_last();
            return val;
        }
        size--;
        int idx = size-1-ind;
        Node tem = head;
        for (int i = 0; i <idx; i++) {
            tem=tem.next;
        }

        int val = tem.next.val;
        tem.next=tem.next.next;
        return val;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
    }
}