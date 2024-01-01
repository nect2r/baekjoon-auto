/*
 * @since 2022-11-17
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

       long a = Integer.parseInt(st.nextToken());
       long b = Integer.parseInt(st.nextToken());

        System.out.println(LCM(a, b, GCD(a, b)));
    }

    //최대공약수
    private static long GCD(long a, long b) {
        if(b == 0) {
            return a;
        }

        if(b > a) {
            GCD(b, a);
        }

        return GCD(b, a % b);
    }
    
    //최소공배수
    private static long LCM(long a, long b, long GCD) {
        return a * b / GCD;
    }
}
