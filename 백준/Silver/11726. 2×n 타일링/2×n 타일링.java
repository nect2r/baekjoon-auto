/*
 * @since 2024-01-02
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        
        System.out.println(make(N) % 10007);
    }
    
    public static int make(int data) {
        if (data < 3) {
            return data;
        } else if (dp[data] == 0) {
            dp[data] = make(data - 1) + make(data - 2) % 10007;   
        }
        
        return dp[data];
    }
}
