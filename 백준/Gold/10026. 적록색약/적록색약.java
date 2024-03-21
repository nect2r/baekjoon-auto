import java.util.*;
import java.io.*;

public class Main {

    static char[][] graph;
    static boolean[][] visit;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visit = new boolean[N][N];
        List<Node> nodes = new ArrayList<>();

        int r1 = 0;
        int r2 = 0;

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                graph[i][j] = line[j];

                if (line[j] == 'G') {
                    nodes.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    r1++;
                    dfs(new Node(i, j));
                }
            }
        }

        for (Node node : nodes) {
            graph[node.y][node.x] = 'R';
        }
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    r2++;
                    dfs(new Node(i, j));
                }
            }
        }

        System.out.println(r1 + " " + r2);
    }

    public static void dfs(Node start) {
        char current = graph[start.y][start.x];
        visit[start.y][start.x] = true;

        for (int i = 0; i < 4; i++) {
            int py = start.y + dy[i];
            int px = start.x + dx[i];

            if (px < 0 || py < 0 || px >= graph.length || py >= graph.length) {
                continue;
            }

            if (visit[py][px] || current != graph[py][px]) {
                continue;
            }

            dfs(new Node(py, px));
        }
    }

    public static class Node {
        int y;
        int x;
        Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
