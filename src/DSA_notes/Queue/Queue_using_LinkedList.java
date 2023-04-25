package DSA_notes.Queue;
public class Queue_using_LinkedList {

    static class Node {
        int val;
        Node next;

        Node(int n) {
            this.val = n;
            this.next = null;
        }
    }
    static class Queue {
        static Node head;
        static Node tail;

        boolean isEmpty() {
            return tail == null && head == null;
        }

        void add(int val) {
            Node q = new Node(val);
            if (isEmpty()) {
                head = tail = q;
                return;
            }
            tail.next = q;
            tail = q;
        }

        Integer remove() {
            if (isEmpty()) {
                System.out.println("Empty");
                return null;
            }
            int val = head.val;
            if (head.next == null) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return val;
        }

        Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return head.val;
        }
    }
    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.remove();
        System.out.println(q.peek());
//
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//        }

    }
}
