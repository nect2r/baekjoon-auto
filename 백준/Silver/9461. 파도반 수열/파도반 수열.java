/*
 * @since 2024-01-16
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
    
    static long[] dp = new long[100];

     public static void main(String []args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
         int count = Integer.parseInt(br.readLine());
         
         dp[0] = dp[1] = dp[2] = 1;
         dp[3] = dp[4] = 2;
         
         for (int i = 0; i < count; i++) {
             sb.append(make(Integer.parseInt(br.readLine()) - 1) + "\n");
         }
         
         System.out.println(sb);
     }
     
     public static long make(int p) {
         if (dp[p] == 0) {
             dp[p] = make(p - 5) + make(p - 1);
         }
         
         return dp[p];
     }
     
     
}