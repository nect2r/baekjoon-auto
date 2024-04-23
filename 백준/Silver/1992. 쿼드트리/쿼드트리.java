import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - 48;
            }
        }

        partition(0, 0, N);
        System.out.println(sb);
    }

    public static void partition(int y, int x, int size) {
        if (size == 0) {
            return;
        }

        if (!comp(y, x, size)) {
            sb.append(board[y][x]);
        } else {
            size = size / 2;

            sb.append("(");
            partition(y, x, size);
            partition(y, x + size, size);
            partition(y + size, x, size);
            partition(y + size, x + size, size);
            sb.append(")");
        }
    }

    public static boolean comp(int y, int x, int size) {
        int cur = board[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (cur != board[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }
}