import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(s, e);
        }

        Arrays.sort(nodes);

        int result = 1;
        int prev = nodes[0].s;

        for (int i = 1; i < N; i++) {
            if (nodes[i].e <= prev) {
                result++;

                prev = nodes[i].s;
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node>{
        int s;
        int e;
        Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o) {
            if (this.s == o.s)
                return o.e - this.e;
            return o.s - this.s;
        }
    }
}