/*
 * @since 2024-02-05
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S1 = br.readLine().toCharArray();
        char[] S2 = br.readLine().toCharArray();

        /*
          A C A Y K P
        C 0 1 1 1 1 1
        A 1 1 2 2 2 2
        P 1 1 2 2 2 3
        C 1 2 2 2 2 3
        A 1 2 3 3 3 3
        K 1 2 3 3 4 4

        n(x, y) = x == y + (x-1 + y-1) or (x-1,y) or (x,y-1)
        */
        int[][] dp = new int[S1.length][S2.length];

        for (int i = 0; i < S1.length; i++) {
            for (int j = 0; j < S2.length; j++) {
                if (i == 0) {
                    if (S1[i] == S2[j]) {
                        dp[i][j] = S1[i] == S2[j] ? 1 : 0;
                    } else {
                        dp[i][j] = j == 0 ? 0 : dp[i][j - 1];
                    }
                } else {
                    if (j == 0) {
                        if (S1[i] == S2[j]) {
                            dp[i][j] = Math.max(S1[i] == S2[j] ? 1 : 0, dp[i - 1][j]);
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), S1[i] == S2[j] ? dp[i - 1][j - 1] + 1 : 0);
                    }
                }
            }
        }

//        for (int i = 0; i < S1.length; i++) {
//            for (int j = 0; j < S2.length; j++) {
//                System.out.print(dp[j][i]);
//            }
//            System.out.println();
//        }
        System.out.println(dp[S1.length - 1][S2.length - 1]);
    }
}