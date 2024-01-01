/*
 * @since 2023-10-23
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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        System.out.println(makeOne(N, 0));
    }

    static int makeOne(int N, int count) {
        if (N < 2) {
            return count;
        }

        return Math.min(makeOne(N / 2, count + 1 + (N % 2)), makeOne(N / 3, count + 1 + (N % 3)));
    }
}
