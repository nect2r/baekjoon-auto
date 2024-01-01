/*
 * @since 2023-01-03
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
        StringTokenizer st = null;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int degit = Integer.parseInt(st.nextToken());

            if(map.containsKey(degit)) {
                map.put(degit, map.get(degit) + 1);
            } else {
                map.put(degit, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int degit = Integer.parseInt(st.nextToken());

            if(map.containsKey(degit)) {
                sb.append(map.get(degit) + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb.toString());
    }
}