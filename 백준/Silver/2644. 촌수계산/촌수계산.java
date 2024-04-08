import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] adjList = new LinkedList[n + 1];

        visit = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        int edges = Integer.parseInt(br.readLine());

        for (int i = 1; i <= edges; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(x1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == x2) {
                break;
            }
            visit[cur] = true;

            for (int i = 0; i < adjList[cur].size(); i++) {
                int next = adjList[cur].get(i);

                if (visit[next]) {
                    continue;
                }

                q.add(next);
                dist[next] = dist[cur] + 1;
            }
        }

        int result = dist[x2] == 0 ? -1 : dist[x2];
        System.out.println(result);
    }
}