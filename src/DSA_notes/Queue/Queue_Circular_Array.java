package DSA_notes.Queue;

public class Queue_Circular_Array {
    static int[] arr;
    static int front;
    static int rear;
    static int size;

    static class Queue {
        Queue(int val) {
            arr = new int[val];
            size = val;
            front = -1;
            rear = -1;
        }

        boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        boolean isFull() {
            return (rear + 1) % size == front;
        }

        void add(int n) {
            if (isFull()) {
                System.out.println("list is full");
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = n;
            if (front == -1) {
                front = 0;
            }
            return;
        }

        Integer remove() {
            if (isEmpty()) {
                System.out.println("List is empty");
                return null;
            }
            int val = arr[front];
            if (front == rear) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return val;
        }

        Integer peek() {
            if (isEmpty()) {
                System.out.println("List is empty");
                return null;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek()+" ");
            q.remove();
        }
    }
}
