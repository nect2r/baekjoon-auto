import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int whiteCnt;
    static int blueCnt;
    static int N;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        board = new int[(N * N) + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[(i * N) + j] = Integer.parseInt(st.nextToken());
            }
        }

        find(N, 1);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    public static int find(int p, int idx) {
        if (p == 1) {
            return board[idx];
        }

        int mod = p / 2;
        int[] dIdx = {idx, idx + mod, idx + (N * mod), idx + mod + (N * mod)};

        int sum = 0;
        int white = 0;
        int blue = 0;

        for (int i = 0; i < 4; i++) {
            int data = find(mod, dIdx[i]);

            sum += data;
            white += data == 0 ? 1 : 0;
            blue += data == 1 ? 1 : 0;
        }

        if (sum != 0 && sum != 4) {
            whiteCnt += white;
            blueCnt += blue;
            board[idx] = 9;
        } else if (p == N) {
            if (sum == 0) {
                whiteCnt++;
            } else if (sum == 4) {
                blueCnt++;
            }
        }

        return board[idx];
    }
}