import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
class Main {

    static int[][] graph;
    static int[] dist;
    static boolean[] visit;
    static int INF = Integer.MAX_VALUE;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s][e] = graph[s][e] > d ? d : graph[s][e];
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijstra(start);

        System.out.println(dist[end]);
    }

    static void dijstra(int start) {
        visit[start] = true;
        dist[start]  = 0;

        for (int i = 1; i <= N; i++) {
            dist[i] = graph[start][i];
        }

        for (int i = 1; i <= N; i++) {
            int min = INF;
            int min_index = -1;

            for (int j = 1; j <= N; j++) {
                if (!visit[j] && min > dist[j]) {
                    min = dist[j];
                    min_index = j;
                }
            }

            if (min_index == -1) {
                continue;
            }

            visit[min_index] = true;
            for (int j = 1; j <= N; j++) {
                if (!visit[j] && graph[min_index][j] != INF) {
                    if (dist[j] > dist[min_index] + graph[min_index][j]) {
                        dist[j] = dist[min_index] + graph[min_index][j];
                    }
                }
            }
        }
    }
}