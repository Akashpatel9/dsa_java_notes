package DSA_notes.Queue;
class Queue_Array{
    static int arr[];
    static int size;
    static int rear;
    static class Queue {
        Queue(int val) {
            arr = new int[val];
            size = val;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int n) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear] = n;
            return;
        }

        public Integer remove() {
            if (isEmpty()) {
                return null;
            }
            int val = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return val;
        }

        public Integer peek() {
            if (isEmpty()) {
                System.out.println("empty");
                return null;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}