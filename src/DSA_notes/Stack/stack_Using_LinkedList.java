package DSA_notes.Stack;

public class stack_Using_LinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class Stack {
        static Node head;

        boolean isEmpty() {
            return head == null;
        }

        void push(int val) {
            Node n = new Node(val);
            if (isEmpty()) {
                head = n;
                return;
            }
            n.next = head;
            n = head;
        }

        Integer pop() {
            if (isEmpty()) {
                return null;
            } else if (head.next == null) {
                int val = head.val;
                head = null;
                return val;
            }
            int val = head.val;
            head = head.next;
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
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.pop();
        s.push(3);
        s.push(4);
        s.pop();
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
