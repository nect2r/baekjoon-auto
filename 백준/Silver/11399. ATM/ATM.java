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

        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[1001];

        st = new StringTokenizer(br.readLine());
        // 주어진 배열을 오름차순으로 변경하고 걸리는 시간을 구하면 최솟값을 구할수있다.
        for (int i = 0; i < count; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int result = 0;
        int prev = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > 0) {
                for (int j = 1; j <= arr[i]; j++) {
                    int time = i;
                    //System.out.println("time : " + time + ", prev : " + prev + ", result : " + (prev + time));
                    result += prev + time;
                    prev = prev + time;
                }
            }
        }

        System.out.println(result);
    }
}
