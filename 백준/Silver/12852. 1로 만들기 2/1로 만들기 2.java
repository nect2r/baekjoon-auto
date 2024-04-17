import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] dp;
    static int[] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());

        dp = new int[X + 1];
        before = new int[X + 1];

        for (int i = 2; i <= X; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
                before[i] = dp[i / 3] > dp[i / 2] ? dp[i / 2] > dp[i - 1] ? i - 1 : i / 2 : dp[i / 3] > dp[i - 1] ? i - 1 : i / 3;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                before[i] = dp[i / 3] > dp[i - 1] ? i - 1 : i / 3;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
                before[i] = dp[i / 2] > dp[i - 1] ? i - 1 : i / 2;
            } else {
                dp[i] = dp[i - 1] + 1;
                before[i] = i - 1;
            }
        }

        sb.append(dp[X]).append("\n");
        sb.append(X).append(" ");
        while (before[X] > 0) {
            sb.append(before[X]).append(" ");
            X = before[X];
        }

        System.out.println(sb);
    }
}