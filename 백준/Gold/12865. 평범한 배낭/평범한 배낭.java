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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] items = new int[N][2];
        int[][] dp = new int[K + 1][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = i - items[j][0] >= 0 ? items[j][1] : 0;
                } else {
                    int max = i - items[j][0] >= 0 ? items[j][1] + dp[i - items[j][0]][j - 1] : 0;
                    int data = Math.max(dp[i - 1][j], dp[i][j - 1]);

                    dp[i][j] = Math.max(max, data);
                }
            }
        }

        // 확인
        /*
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K + 1; j++) {
                    System.out.print(dp[j][i] + " ");
                }
                System.out.println();
            }
        */

        System.out.println(dp[K][N -1]);
    }
}
