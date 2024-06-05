import java.io.*;
import java.util.*;

/*

 */
class Main {

    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);

            return;
        }

        cost = new int[(Math.max(N, K) * 2) + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();

        cost[N] = 0;
        q.add(new Node(N));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.data == K) {
                System.out.println(cost[cur.data]);
                break;
            }

            if (cur.data < K) {
                if (cost[cur.data * 2] > cost[cur.data]) {
                    cost[cur.data * 2] = cost[cur.data];
                    q.add(new Node(cur.data * 2));
                }

                if (cost[cur.data + 1] > cost[cur.data] + 1) {
                    cost[cur.data + 1] = cost[cur.data] + 1;
                    q.add(new Node(cur.data + 1));
                }
            }

            if (cur.data > 1) {
                if (cost[cur.data - 1] > cost[cur.data] + 1) {
                    cost[cur.data - 1] = cost[cur.data] + 1;
                    q.add(new Node(cur.data - 1));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int data;

        Node (int data) {
            this.data = data;
        }

        public int compareTo(Node o) {
            if (cost[this.data] == cost[o.data])
                return this.data - o.data;

            return cost[this.data] - cost[o.data];
        }
    }
}