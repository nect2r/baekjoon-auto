/*
 * @since 2024-03-10
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

    static boolean[] visit;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = 0;

        // DFS 시작
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);

        /*
        1 2 5
        2 4 5
        3 4
        4 3 6
        5 2 4
        6 4

        DFS 에 의해서
        1 배열의 1 2 5 방문(방문여부확인 후)
        2, 5배열 방문 이후 종료 DFS시작으로 돌아와서 1, 2, 5연결 그래프 종료
        3 배열의 3 4 방문
        4 6 배열 방문 종료
         */
    }

    public static void dfs(int start) {
        visit[start] = true;

        for (int n : graph[start]) {
            if (!visit[n]) {
                dfs(n);
            }
        }
    }
}
