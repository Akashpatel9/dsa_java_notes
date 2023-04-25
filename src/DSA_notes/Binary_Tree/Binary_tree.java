package DSA_notes.Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    Node Left,Right;
    int val;
    Node(int val){
        this.val=val;
        this.Left=null;
        this.Right=null;
    }
}



public class Binary_tree {



    //build tree using array inputs--
    static int idx = -1;

    public static Node BuildTree_with_array(int node[]) {
        idx++;
        if (node[idx] == -1) {
            return null;
        }
        Node newNode = new Node(node[idx]);
        newNode.Left = BuildTree_with_array(node);
        newNode.Right = BuildTree_with_array(node);
        return newNode;
    }



    //build tree using user inputs--
//    public static Node BuildTree_with_user_input(){
//
//    }



    //BFS (Breadth first search)    --(Level order traversal)--
    public static void level_order_traversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.val + " ");
            if (n.Left != null) {
                q.offer(n.Left);
            }
            if (n.Right != null) {
                q.offer(n.Right);
            }
        }
    }


    //DFS (Depth first Search)    --Preorder Traversal (LRD)--
    public static void preorder_tra(Node root){
        if (root==null){
            return;
        }
        //LRD
        preorder_tra(root.Left);
        preorder_tra(root.Right);
        System.out.print(root.val+" ");
    }



    //DFS (Depth first Search)    --Postorder Traversal (LDR)--
    public static void postorder_tra(Node root){
        if (root==null){
            return;
        }
        //LDR
        postorder_tra(root.Left);
        System.out.print(root.val+" ");
        postorder_tra(root.Right);
    }



    //DFS (Depth first Search)    --Inorder Traversal (DLR)--
    public static void inorder_tra(Node root){
        if (root==null){
            return;
        }
        //DLR
        System.out.print(root.val+" ");
        postorder_tra(root.Left);
        postorder_tra(root.Right);
    }
}


class Tree{
    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,-1};
        Binary_tree tree = new Binary_tree();
        Node root = tree.BuildTree_with_array(arr);

        tree.level_order_traversal(root);



    }
}
