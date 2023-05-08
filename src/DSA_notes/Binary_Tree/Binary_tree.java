package DSA_notes.Binary_Tree;

import DSA_notes.pair;

import java.util.*;


public class Binary_tree {


    //build tree using array inputs--
    static int idx = -1;

    public static Node BuildTree_with_array(int[] node) {
        idx++;
        if (node.length == 0 || node[idx] == -1) {
            return null;
        }
        Node newNode = new Node(node[idx]);
        newNode.Left = BuildTree_with_array(node);
        newNode.Right = BuildTree_with_array(node);
        return newNode;
    }


    //build tree using user inputs--
    static Scanner sc = new Scanner(System.in);
    static boolean mark = true;

    public static Node BuildTree_with_user_input() {
        if (mark) {
            System.out.println("Enter data");
            mark = !mark;
        }
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node newNode = new Node(data);
        System.out.println("Enter Left data");
        newNode.Left = BuildTree_with_user_input();
        System.out.println("Enter Right data");
        newNode.Right = BuildTree_with_user_input();
        return newNode;
    }


    //DFS (Depth first Search)    --postorder Traversal (LRD)--
    public static void postorder_tra(Node root) {
        if (root == null) {
            return;
        }
        //LRD
        postorder_tra(root.Left);
        postorder_tra(root.Right);
        System.out.print(root.val + " ");
    }


    //DFS (Depth first Search)    --inorder Traversal (LDR)--
    public static void inorder_tra(Node root) {
        if (root == null) {
            return;
        }
        //LDR
        inorder_tra(root.Left);
        System.out.print(root.val + " ");
        inorder_tra(root.Right);
    }


    //DFS (Depth first Search)    --preorder Traversal (DLR)--
    public static void preorder_tra(Node root) {
        if (root == null) {
            return;
        }
        //DLR
        System.out.print(root.val + " ");
        preorder_tra(root.Left);
        preorder_tra(root.Right);
    }


    //hight of the tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.Left);
        int r = height(root.Right);
        return (int) Math.max(l, r) + 1;
    }


    //count nodes of a tree
    public static int count_nodes(Node root) {
        if (root == null) {
            return 0;
        }

        int l = count_nodes(root.Left);
        int r = count_nodes(root.Right);
        return l + r + 1;
    }


    //level order using arrayList----
    public static void level_order_arrayList(Node root, ArrayList<ArrayList<Integer>> ans, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        level_order_arrayList(root.Left, ans, level + 1);
        level_order_arrayList(root.Right, ans, level + 1);

    }


    //BFS (Breadth first search)    --(Level order traversal)--   using (while loop)
    public static void level_order_traversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.offer(null);
                }
            } else {
                System.out.print(curr.val + " ");
                if (curr.Left != null) {
                    q.offer(curr.Left);
                }
                if (curr.Right != null) {
                    q.offer(curr.Right);
                }
            }
        }
        System.out.println();
    }


    //BFS (Breadth first search)    --(Level order traversal)--  (using for loop)
    public static void level_order_traversal_forloop(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                System.out.print(curr.val + " ");
                if (curr.Left != null) {
                    q.offer(curr.Left);
                }
                if (curr.Right != null) {
                    q.offer(curr.Right);
                }
            }
            System.out.println();
        }

        System.out.println();
    }


    //Diameter of a tree-   O(n^2) Comp
    public static int diameter_of_Tree(Node root) {
        if (root == null) {
            return 0;
        }
        int left_hight = height(root.Left);
        int left_diameter = diameter_of_Tree(root.Left);
        int right_hight = height(root.Right);
        int right_diameter = diameter_of_Tree(root.Right);

        int self_diameter = left_hight + right_hight + 1;
        return Math.max(self_diameter, Math.max(left_diameter, right_diameter));
    }


    //Diameter of a tree using pair   O(n) Comp
    public static pair diameter_of_Tree_pair(Node root) {
        if (root == null) {
            pair p = new pair(0, 0);
            return p;
        }
        pair left = diameter_of_Tree_pair(root.Left);
        pair right = diameter_of_Tree_pair(root.Right);
        int hight = Math.max(left.h, right.h) + 1;
        int self_d = left.h + right.h;
        int diameter = Math.max(self_d, Math.max(left.d, right.d));
        return new pair(diameter, hight);
    }


    //helper pair
    static class top_view_pair {
        Node node;
        int horizontal_distance;

        top_view_pair(Node n, int h) {
            this.node = n;
            this.horizontal_distance = h;
        }
    }


    //top view
    public static void top_view(Node root) {

        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<top_view_pair> q = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();

        q.add(new top_view_pair(root, 0));

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                top_view_pair curr = q.poll();

                if (!map.containsKey(curr.horizontal_distance)) {
                    map.put(curr.horizontal_distance, curr.node);
                }

                if (curr.node.Left != null) {
                    q.offer(new top_view_pair(curr.node.Left, curr.horizontal_distance - 1));

                }
                if (curr.node.Right != null) {
                    q.offer(new top_view_pair(curr.node.Right, curr.horizontal_distance + 1));
                }
                min = Math.min(curr.horizontal_distance, min);
                max = Math.max(curr.horizontal_distance, max);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).val + " ");
        }
        System.out.println();
    }


    //bottom view
    public static void bottom_view(Node root) {

        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<top_view_pair> q = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();

        q.add(new top_view_pair(root, 0));

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                top_view_pair curr = q.poll();

                map.put(curr.horizontal_distance, curr.node);

                if (curr.node.Left != null) {
                    q.offer(new top_view_pair(curr.node.Left, curr.horizontal_distance - 1));

                }
                if (curr.node.Right != null) {
                    q.offer(new top_view_pair(curr.node.Right, curr.horizontal_distance + 1));
                }
                min = Math.min(curr.horizontal_distance, min);
                max = Math.max(curr.horizontal_distance, max);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).val + " ");
        }
        System.out.println();
    }


    //left view
    public static void left_view(Node root) {

        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<top_view_pair> q = new LinkedList<>();

        q.add(new top_view_pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                top_view_pair curr = q.poll();

                if (i == 0) {
                    System.out.print(curr.node.val + " ");
                }

                if (curr.node.Left != null) {
                    q.offer(new top_view_pair(curr.node.Left, curr.horizontal_distance - 1));

                }
                if (curr.node.Right != null) {
                    q.offer(new top_view_pair(curr.node.Right, curr.horizontal_distance + 1));
                }
            }
        }
        System.out.println();
    }


    //right view
    public static void right_view(Node root) {

        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<top_view_pair> q = new LinkedList<>();

        q.add(new top_view_pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                top_view_pair curr = q.poll();

                if (i == size - 1) {
                    System.out.print(curr.node.val + " ");
                }

                if (curr.node.Left != null) {
                    q.offer(new top_view_pair(curr.node.Left, curr.horizontal_distance - 1));

                }
                if (curr.node.Right != null) {
                    q.offer(new top_view_pair(curr.node.Right, curr.horizontal_distance + 1));
                }
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {

        /*
                     1
                   /   \
                  2     3
                /  \   /  \
               4   5  6    7

       */

//        Node n = new Node(1);
//        n.Left = new Node(2);
//        n.Right = new Node(3);
//        n.Left.Left = new Node(4);
//        n.Left.Right = new Node(5);
//        n.Right.Left = new Node(6);
//        n.Right.Right = new Node(7);

//


//
//        b.top_view(n);
//        b.bottom_view(n);
//        b.left_view(n);
//        b.right_view(n);


//
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//
//        Binary_tree tree = new Binary_tree();
//
//        Node root = tree.BuildTree_with_array(arr);
////
////        tree.level_order_traversal(root);
//
//        tree.level_order_arrayList(root,ans,0);
//
//        System.out.println(ans);
////
////        System.out.println("hight "+tree.height(root));
////
////        System.out.println("count "+tree.count_nodes(root));

//        Binary_tree tre = new Binary_tree();
//        Node root = tre.BuildTree_with_user_input();
//
//        tre.inorder_tra(root);

//        Binary_tree b = new Binary_tree();
//        Node root = b.BuildTree_with_array(arr);

    }

}
