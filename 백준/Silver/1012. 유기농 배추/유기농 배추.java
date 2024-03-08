import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());

            //보드
            int[][] board = new int[y][x];
            boolean[][] visit = new boolean[y][x];
            Queue<Pair> q = new LinkedList<Pair>();

            for (int j = 0; j < lineCnt; j++) {
                st = new StringTokenizer(br.readLine());

                int px = Integer.parseInt(st.nextToken());
                int py = Integer.parseInt(st.nextToken());

                board[py][px] = 1;
                q.add(new Pair(py, px));
            }

            Queue<Pair> subQ = new LinkedList<Pair>();
            int result = 0;

            while (!q.isEmpty()) {
                if (subQ.isEmpty()) {
                    Pair p = q.poll();

                    if (!visit[p.y][p.x]) {
                        subQ.add(p);
                        visit[p.y][p.x] = true;
                        result++;
                    } else {
                        continue;
                    }
                }

                Pair subP = subQ.poll();

                for (int j = 0; j < 4; j++) {
                    int px = subP.x + dx[j];
                    int py = subP.y + dy[j];

                    if (px < 0 || px >= x || py < 0 || py >= y) {
                        continue;
                    }

                    if (board[py][px] == 0 || visit[py][px]) {
                        continue;
                    }

                    subQ.add(new Pair(py, px));
                    visit[py][px] = true;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static class Pair {
        int x;
        int y;

        Pair (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
