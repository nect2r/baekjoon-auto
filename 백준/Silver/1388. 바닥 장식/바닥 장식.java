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
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visit;
    static char[][] graph;
    static int result;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j] == false) {
                    dfs(new Node(i, j));
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void dfs(Node node) {
        visit[node.y][node.x] = true;
        char cur = graph[node.y][node.x];
        int py = node.y + 1;
        int px = node.x + 1;

        if (cur == '-') {
            if (px < M && visit[node.y][px] == false && graph[node.y][px] == '-') {
                dfs(new Node(node.y, px));
            }
        } else if (cur == '|') {
            if (py < N && visit[py][node.x] == false && graph[py][node.x] == '|') {
                dfs(new Node(py, node.x));
            }
        }
    }

    public static class Node {
        int y;
        int x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
