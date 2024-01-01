/*
 * @since 2023-08-07
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
        StringTokenizer st;

        /*

            1. Equilateral : 세 변의 길이가 모두 같은 경우
            2. Isosceles  : 두 변의 길이만 같은 경우
            3. Scalene : 세 변의 길이가 모두 다른 경우

            - 단 주어진 세 변의 길이가 삼각형의 조건을 못하는 경우에는 "Invalid" 를 출력한다.
            - 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
            - 각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
         */

        //출력
        StringBuilder sb = new StringBuilder();

        while (true) {
            //입력
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //총합
            int sum = a + b + c;

            //최댓값
            int max = Math.max(Math.max(a, b), c);

            //마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
            if (sum == 0) {
                sb.delete(sb.length() - 1, sb.length());
                System.out.println(sb);

                break;
            } else {
                //주어진 세 변의 길이가 삼각형의 조건을 못하는 경우에는 "Invalid" 를 출력한다.
                if (max >= sum - max) {
                    sb.append("Invalid");
                } else {
                    if (a == b && b == c) {
                        sb.append("Equilateral");
                    } else if (a == b || b == c || a == c) {
                        sb.append("Isosceles");
                    } else {
                        sb.append("Scalene");
                    }
                }

                sb.append("\n");
            }
        }
    }
}