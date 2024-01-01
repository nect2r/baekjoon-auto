import java.io.*;
import java.util.*;

public class Main{

     public static void main(String []args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int count = Integer.parseInt(br.readLine());
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         int[] arr = new int[count + 1];
         int[] result = new int[count + 1];
         
         for (int i = 1; i <= count; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }
         
         for (int i = 2; i < arr.length; i++) {
             int data = arr[i];
             int prev = i - 1;
             
             if (data < arr[prev]) {
                 result[i] = prev;
             } else {
                 result[i] = 0;
                 
                 while (result[prev] != 0) {
                     if (data < arr[result[prev]]) {
                         result[i] = result[prev];
                         break;
                     } else {
                         prev = result[prev];
                     }
                 }
             }
         }
         
         StringBuilder sb = new StringBuilder();
         for (int i = 1; i < result.length; i++) {
             sb.append(result[i] + " ");
         }
         System.out.println(sb);
     }
}