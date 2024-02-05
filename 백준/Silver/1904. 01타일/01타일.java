/*
 * @since 2024-02-06
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
    static long[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 2;

        System.out.println(make(N - 1));
    }

    static long make(int N) {
        if (dp[N] == 0) {
            dp[N] = make(N - 1) + make(N - 2);
        }

        return dp[N] % 15746;
    }
}