/*
 * @since 2024-01-17
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] dp = new int[30][30];

     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            
            sb.append(make(x, y)).append("\n");
        }
        
        System.out.println(sb);
     }
     
     static int make(int x, int y) {
         if (x > y) {
             return 0;
         }
         
         if (dp[x][y] == 0) {
             if (x == 0) {
                 dp[x][y] = y + 1;
             } else {
                 dp[x][y] = make(x, y - 1) + make(x - 1, y - 1);
             }
         }
         
         return dp[x][y];
     }
}