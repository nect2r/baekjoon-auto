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

    static long[][] dp = new long[100][9];

     public static void main(String []args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int data = Integer.parseInt(br.readLine()) - 1;

         // 자릿수가 1개의 계단수 9개
         dp[0] = new long[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
         
         long[] result = make(data);
         long sum = 0;
         
         for (int i = 0; i < result.length; i++) {
             sum = ((sum % 1000000000) + (result[i] % 1000000000)) % 1000000000;
         }
         
         System.out.println(sum);
     }
     
     static long[] make(int data) {
         if (dp[data][0] == 0) {
             long[] temp = make(data - 1);
             
             dp[data] = new long[] {
                temp[1] + temp[8] % 1000000000
                ,temp[0] + temp[2] % 1000000000
                ,temp[1] + temp[3] % 1000000000
                ,temp[2] + temp[4] % 1000000000
                ,temp[3] + temp[5] % 1000000000
                ,temp[4] + temp[6] % 1000000000
                ,temp[5] + temp[7] % 1000000000                     
                ,temp[6] + temp[8] % 1000000000 
                ,temp[7] % 1000000000
             };
         }
         
         return dp[data];
     }
}