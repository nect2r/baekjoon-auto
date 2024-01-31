/*
 * @since 2024-01-31
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

    static long[] dp = new long[91];

     public static void main(String []args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         
         dp[0] = 0;
         dp[1] = 1;
         
         System.out.println(make(n));
     }
     
     static long make(int n) {
         if (n > 1 && dp[n] == 0) {
             dp[n] = make(n - 1) + make(n - 2);
         }
         
         return dp[n];
     }
}