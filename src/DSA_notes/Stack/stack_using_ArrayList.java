package DSA_notes.Stack;

import java.util.ArrayList;

public class stack_using_ArrayList {
    static class Stack {
        static ArrayList<Integer> al = new ArrayList<>();

        boolean isEmpty() {
            return al.size() == 0;
        }

        void push(int n) {
            al.add(n);
        }

        Integer pop() {
//            if (isEmpty()) {
//                System.out.println("Empty");
//                return null;
//            }
            int val = al.get(al.size() - 1);
            al.remove(al.size() - 1);
            return val;
        }

        Integer peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            return al.get(al.size() - 1);
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
