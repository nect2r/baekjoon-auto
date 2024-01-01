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
        int M = Integer.parseInt(st.nextToken());
        long MAX_VALUE = Integer.MIN_VALUE;

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

            if (MAX_VALUE < trees[i]) {
                MAX_VALUE = trees[i];
            }
        }

        long start = 1;
        long end = MAX_VALUE;

        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < trees.length; i++) {
                if (trees[i] >= mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
