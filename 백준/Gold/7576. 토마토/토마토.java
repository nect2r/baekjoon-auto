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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] board = new int[y][x];
        int[][] visit = new int[y][x];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<Pair>();
        int zeroCount = 0;

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < x; j++) {
                int tomato = Integer.parseInt(st.nextToken());

                if (tomato == 0) {
                    zeroCount++;
                } else if (tomato == 1) {
                    q.add(new Pair(i, j));
                    //visit[i][j] = 1;
                }

                board[i][j] = tomato;
            }
        }

        int plusCount = 0 - q.size();
        int lastCount = 0;

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];

                // 벽
                if (px < 0 || px >= x || py < 0 || py >= y) {
                    continue;
                }

                // 방문여부
                if (board[py][px] != 0 || visit[py][px] != 0) {
                    continue;
                }

                q.add(new Pair(py, px));
                visit[py][px] = visit[p.y][p.x] + 1;
            }

            plusCount++;
            lastCount = visit[p.y][p.x];
            //.out.println("y : " + p.y + ", x : " + p.x + ", visit : " + visit[p.y][p.x]);
        }

        if (zeroCount == plusCount) {
            System.out.println(lastCount);
        } else {
            System.out.println(-1);
        }

        /*for (int[] v : visit) {
            for (int vd : v) {
                System.out.print(vd + " ");
            }
            System.out.println();
        }*/
    }

    public static class Pair {
        int x, y;
        Pair (int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
