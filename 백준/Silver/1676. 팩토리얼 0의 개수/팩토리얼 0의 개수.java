/*
 * @since 2023-10-19
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

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer num = Integer.parseInt(br.readLine());
        int count = 0;

        while(num >= 5) {
            count += num / 5;
            num = num / 5;
        }

        System.out.println(count);
    }
}
