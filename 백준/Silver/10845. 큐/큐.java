import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i=0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            String method = st.nextToken();
            int point = 0;

            if(method.equals("push")) {
                point = Integer.parseInt(st.nextToken());
                push(point);
            } else if(method.equals("pop")) {
                System.out.println(pop());
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

    public static void push(int x) {
        queue.add(x);
    }

    public static int pop() {
        if(queue.size() == 0) {
            return -1;
        }

        return queue.pop();
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        if(queue.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static int front() {
        if(queue.size() == 0) {
            return -1;
        }

        return queue.getFirst();
    }

    public static int back() {
        if(queue.size() == 0) {
            return -1;
        }

        return queue.getLast();
    }
}