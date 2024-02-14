/*
 * @since 2024-02-02
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1, st2;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n][2];
            dp = new Integer[n][2];

            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[j][0] = Integer.parseInt(st1.nextToken());
                arr[j][1] = Integer.parseInt(st2.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];

            Integer[] temp = make(n - 1);

            sb.append(Math.max(temp[0], temp[1])).append("\n");
        }

        System.out.println(sb);
    }

    static Integer[] make(int data) {
        if (dp[data][0] == null && dp[data][1] == null) {
            if (data == 1) {
                dp[data][0] = dp[data - 1][1] + arr[data][0];
                dp[data][1] = dp[data - 1][0] + arr[data][1];
            } else {
                Integer temp1[] = make(data - 1);
                Integer temp2[] = make(data - 2);

                dp[data][0] = Math.max(arr[data][0] + temp1[1], arr[data][0] + temp2[1]);
                dp[data][1] = Math.max(arr[data][1] + temp1[0], arr[data][1] + temp2[0]);
            }
        }

        return dp[data];
    }
}
