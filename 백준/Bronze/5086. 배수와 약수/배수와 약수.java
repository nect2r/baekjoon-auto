/*
 * @since 2023-02-17
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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1. first가 second의 약수이다. factor
        // 2. frist가 second의 배수이다. multiple
        // 3. 둘다 아니라면 neither

        while(true) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            
            if(first == 0 && second == 0) {
                break;
            }else if(second % first == 0) {
                sb.append("factor\n");
            } else if(first % second == 0) {
                sb.append("multiple\n");
            } else {
                sb.append("neither\n");
            }
        }        

        System.out.println(sb.toString());
    }
}