/*
 * @since 2023-02-21
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1;

			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}

		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
}