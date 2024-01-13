/*
 * @since 2024-01-13
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
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        int[][] dp = new int[count][3];
        
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            if (i == 0) {
                dp[i][0] = x;
                dp[i][1] = y;
                dp[i][2] = z;
            } else {
                dp[i][0] = x + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = y + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = z + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        
        System.out.println(Math.min(Math.min(dp[count - 1][0],dp[count - 1][1]),dp[count - 1][2]));
    }
}