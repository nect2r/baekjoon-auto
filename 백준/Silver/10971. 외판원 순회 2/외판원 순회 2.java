import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[][] graph;
    static int n;
    static int result = Integer.MAX_VALUE;
    static int check = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            max += 1 << i;
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, 0);
        }

        System.out.println(result);
    }

    public static void dfs(int g, int s, int sum) {
        for (int i = 0; i < n; i++) {
            if (graph[s][i] == 0) {
                continue;
            }

            int next = 1 << i;

            if (check == (check | next)) {
                continue;
            }
            if (g == i && (check | next) != max) {
                continue;
            }
            if (g == i) {
                if (result > sum + graph[s][i]) {
                    result = sum + graph[s][i];
                }
            }
            if (result < sum + graph[s][i]) {
                continue;
            }

            check = check | next;
            dfs(g, i, sum + graph[s][i]);
            check = check & (~next);
        }
    }
}