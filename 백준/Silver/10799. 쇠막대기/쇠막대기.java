/*
 * @since 2023-12-24
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int stack = 0;
        int count = 0;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' && input.charAt(i + 1) == ')') {
                count += stack;
                i++;
            } else if (c == '(') {
                stack++;
            } else if (c == ')') {
                stack--;
                count++;
            }
        }

        System.out.println(count);
    }
}
