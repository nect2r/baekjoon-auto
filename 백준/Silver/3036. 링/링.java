/*
 * @since 2023-02-20
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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int value = 0;
        
        for(int i = 0; i < count; i++) {
            if(i == 0) {
                value = Integer.parseInt(st.nextToken());
            } else {
                int data = Integer.parseInt(st.nextToken());
                int r = gdc(value, data);
                sb.append(value / r + "/" + data / r + "\n");
            }
        }
        
        System.out.println(sb.toString());
    }

    public static int gdc(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a; 
    }
}