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

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer count = Integer.parseInt(br.readLine());
        int[] arr = new int[31];

        // 입력배열
        for (int i = 0; i < count; i++ ) {
            int point = Integer.parseInt(br.readLine());

            arr[point]++;
        }

        // 15퍼 절사평균 갯수 구함
        int splitLowAvg = (int)Math.round(count * 0.15);
        int splitHighAvg = splitLowAvg;

        // 하위 15퍼 제거
        for (int i = 1; i < 31; i++ ) {
            if (arr[i] > 0) {
                if (splitLowAvg > 0) {

                    // 빼고도 남으면
                    if (arr[i] - splitLowAvg >= 0) {
                        arr[i] = arr[i] - splitLowAvg;
                        splitLowAvg = 0;
                    } else {
                        splitLowAvg = splitLowAvg - arr[i];
                        arr[i] = 0;
                    }
                } else {
                    break;
                }
            }
        }

        // 상위 15퍼 제거
        for (int i = 30; i > 0; i-- ) {
            if (arr[i] > 0) {
                if (splitHighAvg > 0) {

                // 빼고도 남으면
                    if (arr[i] - splitHighAvg >= 0) {
                        arr[i] = arr[i] - splitHighAvg;
                        splitHighAvg = 0;
                    } else {
                        splitHighAvg = splitHighAvg - arr[i];
                        arr[i] = 0;
                    }
                } else {
                    break;
                }
            }
        }

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < 31; i++ ) {
            if (arr[i] > 0) {
                sum += arr[i] * i;
                cnt += arr[i];
            }
        }

        System.out.println(Math.round((double)sum / cnt));
    }
}
