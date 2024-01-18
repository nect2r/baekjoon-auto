/*
 * @since 2024-01-18
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

    static int[] dp = new int[1001];

     public static void main(String []args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int count = Integer.parseInt(br.readLine());

         dp[0] = 1;
         dp[1] = 3;
         
         System.out.println(make(count - 1));
     }
     
     static int make(int p) {
         if (dp[p] == 0) {
             dp[p] = (make(p - 1) + (make(p - 2) * 2)) % 10007;
         }
         
         return dp[p];
     }
     
}