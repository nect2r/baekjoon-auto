/*
 * @since 2023-10-21
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

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int [N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		// 배열의 뒤부터 큰수로 K를 나눠서 최솟값을 구하자.

		for (int i = N - 1; i >= 0; i--) {
			if (K % arr[i] != K) {
				result += K / arr[i];
				K = K % arr[i];
			}
		}

		System.out.println(result);
	}
}
