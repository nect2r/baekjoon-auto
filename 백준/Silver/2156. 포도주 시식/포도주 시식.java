/*
 * @since 2024-02-19
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
    
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(br.readLine());
        arr = new int[count + 1];
        dp = new Integer[count + 1];
        
        for (int i = 1; i <= count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];;
        if (count > 1) {
            dp[2] = arr[1] + arr[2];
        }
        
        System.out.println(make(count));
    }
    
    // (P3 + P2 + D0(23)) or (P3 + D1(19)) or (D2(16))
    static int make(int data) {
        if (dp[data] == null) {
            dp[data] = Math.max(arr[data] + make(data - 2), Math.max(arr[data] + arr[data - 1] + make(data - 3), make(data - 1)));
        }
        
        return dp[data];
    }
}
