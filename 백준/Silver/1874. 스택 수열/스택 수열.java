/*
 * @since 2023-05-06
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 개수 n
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); 

        int point = 1;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());

            if(point > number) {
                if(stack.peek() == number) {
                    sb.append("-\n");
                    stack.pop();
                } else {
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            } else {
                while(point <= number) {
                    stack.push(point);
                    sb.append("+\n");
    
                    if(stack.peek() == number) {
                        sb.append("-\n");
                        stack.pop();
                    }
    
                    point++;
                }
            }
        }

        System.out.println(sb.toString());
    }
}