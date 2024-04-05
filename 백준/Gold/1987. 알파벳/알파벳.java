import java.util.*;
import java.io.*;

public class Main {

    static char[][] graph;
    static int[][] dist;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();

            graph[i] = line;
        }

        dist[0][0] = 1;
        dfs(new Node(0,0, new boolean[26]));

        System.out.println(max);
    }

    static int max = 1;

    public static void dfs(Node s) {
        s.apl[graph[s.y][s.x] - 65] = true;

        for (int i = 0; i < 4; i++) {
            int py = s.y + dy[i];
            int px = s.x + dx[i];

            if (px < 0 || py < 0 || px >= C || py >= R) {
                continue;
            }

            if (s.apl[graph[py][px] - 65]) {
                continue;
            }

            dist[py][px] = dist[s.y][s.x] + 1;
            dfs(new Node(py, px, s.apl.clone()));
            if (dist[py][px] > max) {
                max = dist[py][px];
            }
        }
    }
    public static class Node {
        int y;
        int x;
        boolean[] apl;
        Node (int y, int x, boolean[] apl) {
            this.y = y;
            this.x = x;
            this.apl = apl;
        }
    }
}
