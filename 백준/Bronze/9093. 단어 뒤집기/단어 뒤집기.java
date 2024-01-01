/*
 * @since 2023-05-06
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 개수 T
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            sb.append(wordFlip(br.readLine()));
        }

        System.out.println(sb.toString());
    }

    public static String wordFlip(String line) {
        StringTokenizer st = new StringTokenizer(line);
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            char[] chars = st.nextToken().toCharArray();

            //뒤집기
            for(int i = 0; i < chars.length / 2; i ++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }

            sb.append(new String(chars));

            //가장 마지막만 제외하고 띄어쓰기를 넣기위함
            if(st.hasMoreTokens()) {
                sb.append(" ");
            }
        }

        //줄넘김
        sb.append("\n");

        return sb.toString();
    }
}