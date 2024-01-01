/*
 * @since 2021-10-17
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

        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());
        Integer B = Integer.parseInt(st.nextToken());

        int MAX_VALUE = Integer.MIN_VALUE;
        int MIN_VALUE = Integer.MAX_VALUE;

        int[][] arr = new int[N][M];
        double sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];

                if (arr[i][j] > MAX_VALUE) {
                    MAX_VALUE = arr[i][j];
                }

                if (arr[i][j] < MIN_VALUE) {
                    MIN_VALUE = arr[i][j];
                }
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int k = MIN_VALUE; k <= MAX_VALUE; k++ ) {

            int time = 0;
            int block = B;

            // 기준보다 높다면 층을 낮춘다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > k) {
                        int diff = arr[i][j] - k;
                        block += diff;
                        time += diff * 2;
                    }
                }
            }

            boolean check = true;

            // 기준보다 낮다면 층을 올린다.
            loopTop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] < k) {
                        int diff = k - arr[i][j];
                        if(block - diff < 0) {
                            check = false;
                            break loopTop;
                        }
                        block -= diff;
                        time += diff;
                    }
                }
            }

            if (check) {
                if (minTime == time && k > maxHeight) {
                    maxHeight = k;
                } else if (minTime > time) {
                    maxHeight = k;
                    minTime = time;
                }
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }
}
