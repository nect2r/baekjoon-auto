import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<Integer>[] adjList;
    static int[] dist;
    static int K;
    static int X;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new LinkedList[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        while (!q.isEmpty()) {
            int curNode = q.poll();

            List<Integer> cur = adjList[curNode];

            for (int i = 0; i < cur.size(); i++) {
                int p = cur.get(i);

                if (p == X || dist[p] != 0) {
                    continue;
                }

                dist[p] = dist[curNode] + 1;

                if (dist[p] == K) {
                    result.add(p);
                    continue;
                }

                q.add(p);
            }
        }

        if (result.size() == 0) {
            sb.append("-1");
        } else {
            Collections.sort(result);

            for (int r : result) {
                sb.append(r).append("\n");
            }
        }

        System.out.println(sb);
    }
}