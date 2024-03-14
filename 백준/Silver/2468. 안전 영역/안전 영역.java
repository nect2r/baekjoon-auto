import java.util.*;
import java.io.*;

public class Main {

    static int[] unf;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int maxHeight = 1;

        int result = 1;

        //지역 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());

                //최대 강수량
                if (data > maxHeight) {
                    maxHeight = data;
                }

                board[i][j] = data;
            }
        }

        for (int h = 1; h < maxHeight; h++) {
            Queue<Node> startQ = new LinkedList<>();
            boolean[][] visit = new boolean[N][N];

            unf = new int[(N * N) + 1];

            //잠기지 않은 인덱스를 구함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = board[i][j] - 1;

                    if (board[i][j] > 0) {
                        startQ.add(new Node(j, i));
                        unf[((i * N) + j) + 1] = ((i * N) + j) +1;
                    }
                }
            }

            Queue<Node> edgeQ = new LinkedList<>();

            //인접 간선확인
            while(!startQ.isEmpty()) {
                if (edgeQ.isEmpty()) {
                    Node startNode = startQ.poll();

                    if (visit[startNode.y][startNode.x]) {
                        continue;
                    }

                    edgeQ.add(startNode);
                }

                Node node = edgeQ.poll();
                visit[node.y][node.x] = true;

                for (int i = 0; i < 4; i++) {
                    int px = node.x + dx[i];
                    int py = node.y + dy[i];

                    //사이즈 확인
                    if (px < 0 || py < 0 || px >= N || py >= N) {
                        continue;
                    }

                    if (visit[py][px] || board[py][px] <= 0) {
                        continue;
                    }

                    edgeQ.add(new Node(px, py));
                    visit[py][px] = true;

                    merge(((node.y * N) + node.x) + 1, ((py * N) + px) + 1);
                }
            }

            Set<Integer> resultSet = new HashSet<>();

            for (int i = 1; i < unf.length; i++) {
                if (unf[i] > 0) {
                    resultSet.add(unf[i]);
                }
            }

            if (result < resultSet.size()) {
                result = resultSet.size();
            }
        }

        System.out.println(result);
    }

    public static class Node {
        int x;
        int y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int find(int x) {
        if (x == unf[x])
            return x;

        return unf[x] = find(unf[x]);
    }

    public static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        if (x > y) {
            unf[x] = y;
        } else {
            unf[y] = x;
        }
    }
}
