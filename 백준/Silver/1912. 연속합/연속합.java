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
         int[] arr = new int[count];
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         for (int i = 0; i < count; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }
         
         int result = arr[0];
         for (int i = 1; i < count; i++) {
             if (arr[i - 1] > 0) {
                 arr[i] = arr[i] + arr[i - 1];
             }
             
             if (arr[i] > result) {
                 result = arr[i];
             }
         }
         
         System.out.println(result);
     }
}