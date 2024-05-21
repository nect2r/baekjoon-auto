import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 1));

        int result = -1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.data == B) {
                result = cur.cnt;
                break;
            }

            long p1 = cur.data * 2;
            long p2 = (cur.data * 10) + 1;

            if (p1 <= B) {
                q.add(new Node(p1, cur.cnt + 1));
            }

            if (p2 <= B) {
                q.add(new Node(p2, cur.cnt + 1));
            }
        }

        System.out.println(result);
    }

    static class Node {
        long data;
        int cnt;

        Node (long data, int cnt) {
            this.data = data;
            this.cnt = cnt;
        }
    }
}