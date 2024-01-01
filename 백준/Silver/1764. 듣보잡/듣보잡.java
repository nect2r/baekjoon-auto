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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        Map<String,String> map = new HashMap();
        List<String> list = new ArrayList<String>();

        for(int i = 0; i < N; i++) {
            String name = br.readLine();

            map.put(name, name);
        }

        for(int i = 0; i < M; i++) {
            String name = br.readLine();

            if(map.containsKey(name)) {
                list.add(name);
                answer++;
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(answer + "\n");

        for(String str : list) {
            sb.append(str + "\n");
        }
        System.out.println(sb.toString());
    }
}