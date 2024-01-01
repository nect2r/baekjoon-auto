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
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long maxValue = Integer.MIN_VALUE;

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // 탐색 기준
        long start = 1;
        long end = maxValue;

        while (start <= end) {

            long mid = (start + end) / 2;
            long count = 0;
            //System.out.println(start + " : " + mid + " : " + end);

            for (int j = 0; j < arr.length; j++) {
                count += arr[j] / mid;
            }

            if (count < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
