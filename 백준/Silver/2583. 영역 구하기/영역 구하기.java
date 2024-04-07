/*
 * @since 2024-04-07
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int M;
    static int N;

    static List<Integer> results = new ArrayList<>();
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    graph[k][j] = 1;
                }
            }
        }

        result = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    dfs(i, j);
                    results.add(result);
                    result = 0;
                }
            }
        }

        Collections.sort(results);

        sb.append(results.size()).append("\n");
        for (int r : results) {
            sb.append(r).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int y, int x) {
        graph[y][x] = 1;
        result++;

        for (int i = 0; i < 4; i++) {
            int py = y + dy[i];
            int px = x + dx[i];

            if (py < 0 || px < 0 || py >= M || px >= N) {
                continue;
            }

            if (graph[py][px] == 1) {
                continue;
            }

            dfs(py, px);
        }
    }
}
