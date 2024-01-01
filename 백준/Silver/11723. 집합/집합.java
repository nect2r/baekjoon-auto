/*
 * @since 2023-10-20
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
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1부터 20까지의 집합을 배열로 사용하기
        int[] arr = new int[21];

        // 연산의 수
        int M = Integer.parseInt(st.nextToken());

        // 연산의 수만큼 실행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String msg = st.nextToken();
            int digit = 0;

            if (msg.equals("add")) {
                digit = Integer.parseInt(st.nextToken());

                if (arr[digit] == 0) {
                    arr[digit] = 1;
                }
            } else if (msg.equals("remove")) {
                digit = Integer.parseInt(st.nextToken());

                if (arr[digit] != 0) {
                    arr[digit] = 0;
                }
            } else if (msg.equals("check")) {
                digit = Integer.parseInt(st.nextToken());

                if (arr[digit] == 0) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (msg.equals("toggle")) {
                digit = Integer.parseInt(st.nextToken());

                if (arr[digit] == 0) {
                    arr[digit] = 1;
                } else {
                    arr[digit] = 0;
                }
            } else if (msg.equals("all")) {
                for (int j = 1; j < 21; j++) {
                    arr[j] = 1;
                }
            } else if (msg.equals("empty")) {
                arr = new int [21];
            }
        }

        System.out.println(sb);
    }
}
