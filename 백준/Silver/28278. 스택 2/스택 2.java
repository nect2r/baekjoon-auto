/*
 * @since 2023-09-08
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
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //초기 클래스의 스레드 세이프한 Stack은 단일 스레드에서 성능에 부정적이므로 Deque로 변경
        //SonarLint S1149
        //https://sonarcloud.io/organizations/default/rules?languages=java&open=java%3AS1149&q=S1149
        //Stack<Integer> stack = new Stack<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int data = Integer.parseInt(st.nextToken());

                deque.push(data);
            } else if (type == 2) {
                sb.append(!deque.isEmpty() ? deque.pop() : - 1).append("\n");
            } else if (type == 3) {
                sb.append(deque.size()).append("\n");
            } else if (type == 4) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else {
                sb.append(!deque.isEmpty() ? deque.peek() : - 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
