/*
 * @since 2024-03-17
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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int[][] dist;

    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
/*

- 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0
0 1 0 0 2 0 0 0
0 0 0 2 0 0 0 0
2 0 2 0 0 0 0 0
0 0 3 0 3 0 0 0
0 3 4 3 0 0 0 0
5 0 0 4 0 0 0 0

 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int L = Integer.parseInt(br.readLine());

            graph = new int[L][L];
            dist = new int[L][L];

            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();

            q.add(new Node(sx, sy));

            //bfs
            while(!q.isEmpty()) {
                Node node = q.poll();

                if (node.x == ex && node.y == ey) {
                    sb.append(dist[ey][ex]).append("\n");
                    break;
                }

                //위치 이동
                for (int j = 0; j < 8; j++) {

                    int mx = node.x + dx[j];
                    int my = node.y + dy[j];

                    //숫자방지
                    if (mx < 0 || my < 0 || mx >= L || my >= L) {
                        continue;
                    }

                    //재방문금지, 시작점금지
                    if (dist[my][mx] != 0 || (mx == sx && my == sy)) {
                        continue;
                    }

                    q.add(new Node(mx, my));
                    dist[my][mx] = dist[node.y][node.x] + 1;
                }
            }
        }
        System.out.println(sb);
    }

    public static class Node {
        int x;
        int y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
