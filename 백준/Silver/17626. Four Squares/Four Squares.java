import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

 */
class Main {

    static int[] dp = new int[50001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1];

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)]);
            }

            dp[i]++;
        }

        System.out.println(dp[N]);
    }
}