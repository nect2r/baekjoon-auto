/*
 * @since 2024-01-06
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < count; i++) {
            int data = Integer.parseInt(br.readLine());
            sb.append(make(data)).append("\n");
        }

        System.out.println(sb);
    }

    static int make(int N) {
        if (dp[N] == 0 && N > 3) {
            dp[N] = make(N - 1) + make(N - 2) + make(N - 3);
        }

        return dp[N];
    }

}