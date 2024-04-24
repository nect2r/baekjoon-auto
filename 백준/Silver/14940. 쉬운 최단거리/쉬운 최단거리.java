import java.io.*;
import java.util.*;

class Main {

    static int[][] board;
    static int[][] dist;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[N][M];
        Node sNode = null;

        for (int i =0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    dist[i][j] = -1;
                } else if (board[i][j] == 2) {
                    sNode = new Node(i, j);
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(sNode);

        while (!q.isEmpty()) {
            Node p = q.poll();

            for (int i = 0; i < 4; i++) {
                int py = p.y + dy[i];
                int px = p.x + dx[i];

                if (py < 0 || py >= N || px < 0 || px >= M) {
                    continue;
                }

                if (dist[py][px] != -1) {
                    continue;
                }

                dist[py][px] = dist[p.y][p.x] + 1;
                q.add(new Node(py, px));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] d : dist) {
            for (int r : d) {
                sb.append(r).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Node {
        int y;
        int x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}