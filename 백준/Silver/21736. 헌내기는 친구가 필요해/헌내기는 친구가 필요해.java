import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*

3 5
OOOPO
OIOOX
OOOXP

 */
class Main {

    static boolean[][] visit;
    static char[][] board;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visit = new boolean[N][M];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'I') {
                    q.add(new Node(i, j));
                    visit[i][j] = true;
                }
            }
        }

        int result = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int py = cur.y + dy[i];
                int px = cur.x + dx[i];

                if (py < 0 || px < 0 || py >= N || px >= M) {
                    continue;
                }

                if (visit[py][px] || board[py][px] == 'X') {
                    continue;
                }

                //System.out.println("? " + board[py][px] + ", y " + py + ", x " + px);

                if (board[py][px] == 'P') {
                    result++;
                }

                q.add(new Node(py, px));
                visit[py][px] = true;
            }
        }
        
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    static class Node {
        int x;
        int y;
        Node (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}