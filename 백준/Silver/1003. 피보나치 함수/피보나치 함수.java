/*
 * @since 2023-10-23
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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            fibonacci(n);

            sb.append(hash[n][1]).append(" ").append(hash[n][2]).append("\n");
        }

        System.out.println(sb);
    }

    static int[][] hash = new int[41][3];

    private static int[] fibonacci(int n) {
        if (n == 0) {
            hash[0] = new int[] {1, 1, 0};
            return hash[0];
        } else if (n == 1) {
            hash[1] = new int[] {1, 0, 1};
            return hash[1];
        } else {
            if (hash[n][0] == 0) {
                hash[n][0] = 1;
                int[] first = fibonacci(n - 1);
                int[] second = fibonacci(n - 2);

                hash[n][1] = first[1] + second[1];
                hash[n][2] = first[2] + second[2];

                return hash[n];
            }
            return hash[n];
        }
    }
}
