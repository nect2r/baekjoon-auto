import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[][] board;
    static int mOne;
    static int zero;
    static int one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(mOne);
        System.out.println(zero);
        System.out.println(one);
    }

    public static void partition(int y, int x, int size) {
        if(check(y, x, size)) {
            size = size / 3;
            int pSize = size + size;

            int[] dy = {0, 0, 0, size, size, size, pSize, pSize, pSize};
            int[] dx = {0, size, pSize, 0, size, pSize, 0, size, pSize};

            if (size > 0) {
                for (int i = 0; i < 9; i++) {
                    partition(y + dy[i], x + dx[i], size);
                }
            }
        } else {
            int data = board[y][x];

            mOne += data == -1 ? 1 : 0;
            zero += data == 0 ? 1 : 0;
            one += data == 1 ? 1 : 0;
        }
    }

    public static boolean check(int y, int x, int size) {
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