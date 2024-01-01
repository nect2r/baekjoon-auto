/*
 * @since 2023-09-06
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

    //최대값까지의 소수정리
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
         //소수정리
        makePrime();

        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());

            sb.append(getAddPrimeCount(data)).append("\n");
        }

        System.out.println(sb.toString());
    }

    //소수정리
    public static void makePrime() {

        prime[0] = prime[1] = true;

        for(int i = 2; i < Math.sqrt(prime.length); i++) {
            if(prime[i]) {
                continue;
            }

            for(int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }

    //소수의 합 카운팅
    public static int getAddPrimeCount(int data) {
        int count = 0;

        for(int i = 2; i < data / 2 + 1; i++) {
            if(!prime[i] && !prime[data - i]) {
                count++;
            }
        }

        return count;
    }
}