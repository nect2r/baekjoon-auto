/*
 * @since 2023-08-11
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

        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            long data = Long.parseLong(st.nextToken());

            while (true) {
                if (data < 2) {
                    data = 2;
                    continue;
                }

                if (isPrime(data)) {
                    sb.append(data).append("\n");
                    break;
                } else {
                    data++;
                }
            }
        }

        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }

    private static boolean isPrime(long data) {
        for (int i = 2; i <= (int) Math.sqrt(data); i++) {
            if (data % i == 0) {
                return false;
            }
        }

        return true;
    }
}
