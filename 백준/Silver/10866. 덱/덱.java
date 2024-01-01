import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i=0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            String method = st.nextToken();
            int point = 0;

            if(method.equals("push_front")) {
                point = Integer.parseInt(st.nextToken());
                push_front(point);
            } else if(method.equals("push_back")) {
                point = Integer.parseInt(st.nextToken());
                push_back(point);
            } else if(method.equals("pop_front")) {
                System.out.println(pop_front()); 
            } else if(method.equals("pop_back")) {
                System.out.println(pop_back());
            } else if(method.equals("size")) {
                System.out.println(size());
            } else if(method.equals("empty")) {
                System.out.println(empty());
            } else if(method.equals("front")) {
                System.out.println(front());
            } else if(method.equals("back")) {
                System.out.println(back());
            }
        }
    }

    public static void push_front(int x) {
        deque.addFirst(x);
    }

    public static void push_back(int x) {
        deque.addLast(x);
    }

    public static int pop_front() {
        if(deque.size() == 0) {
            return -1;
        }

        return deque.removeFirst();
    }

    public static int pop_back() {
        if(deque.size() == 0) {
            return -1;
        }

        return deque.removeLast();
    }

    public static int size() {
        return deque.size();
    }

    public static int empty() {
        if(deque.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static int front() {
        if(deque.size() == 0) {
            return -1;
        }

        return deque.getFirst();
    }

    public static int back() {
        if(deque.size() == 0) {
            return -1;
        }

        return deque.getLast();
    }
}