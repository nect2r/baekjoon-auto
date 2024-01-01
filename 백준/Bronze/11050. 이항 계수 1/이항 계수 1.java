/*
 * @since 2023-02-20
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
        int K = Integer.parseInt(st.nextToken());

        //이항 계수1
        //(N | K) N개중 K개를 순서없이 고르는 조합의 수
        //N! / (N - K)!K! 으로 식이 나옴
        int demo = Fac(N - K) * Fac(K);
        int num = Fac(N);

        if(K == 0 || demo == 0) {
            System.out.println(1);
        } else {
            System.out.println(num / demo);
        }
    }

    //팩토리얼 구현
    public static int Fac(int value) {
        if(value <= 1) {
            return value;
        } else {
            return Fac(value - 1) * value;
        }
    }
}