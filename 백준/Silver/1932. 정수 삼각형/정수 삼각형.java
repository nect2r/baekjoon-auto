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

     public static void main(String []args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int count = Integer.parseInt(br.readLine());
         int[][] arr = new int[count][count];
         StringTokenizer st;
         
         for (int i = 0; i < count; i++) {
             st = new StringTokenizer(br.readLine());
         
             for (int j = 0; j <= i; j++) {
                 arr[i][j] = Integer.parseInt(st.nextToken());
             }
         }
         
         for (int i = count - 2; i >= 0; i--) {
             for (int j = 0; j <= i; j++) {
                 arr[i][j] = arr[i][j] + Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
             }
         }
         
         System.out.println(arr[0][0]);
     }
}