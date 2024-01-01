/*
 * @since 2023-01-03
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
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        Map<String,String> map = new HashMap<>();

        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String action = st.nextToken();

            if(action.equals("enter")) {
                map.put(name, name);
            } else {
                map.remove(name);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        //순서변경
        Collections.sort(list, Collections.reverseOrder());

        //Sb생성
        StringBuilder sb = new StringBuilder();
        for(String name : list) {
            sb.append(name).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());

        System.out.println(sb);
    }
}
