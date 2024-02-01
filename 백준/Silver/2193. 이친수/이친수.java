/*
 * @since 2024-02-01
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.*;
import java.util.*;

public class Main {

    static long dp[] = new long[90];

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data = Integer.parseInt(br.readLine()) - 1;

        dp[0] = 1;
        dp[1] = 1;

        System.out.println(make(data));
    }

    static long make(int data) {
        if (dp[data] == 0) {
            dp[data] = make(data - 1) + make(data - 2);
        }

        return dp[data];
    }
}