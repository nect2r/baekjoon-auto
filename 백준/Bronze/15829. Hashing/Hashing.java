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

        int L = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        long sum = 0;
        long pow = 1;

        for(int i = 0; i < L; i ++) {
            sum += (str.charAt(i) - 96) * pow;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(sum % 1234567891);
    }

}
