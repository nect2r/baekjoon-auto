/*
 * @since 2023-02-28
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//n개의 배열생성
		int[] arr = new int[n];

		//순서대로 초기화
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		int begin;
		int end;
		int mid;

		// 1 2 3 4 5 6 7 8 9 10
		// 4 5 6 1 2 3 7 8 9 10

		// 1 2 3 4 5 6 7 8 9 10
		// 1 2 8 9 3 4 5 6 7 10

		for(int i = 0; i < m; i++) {
			//깊은 복사 주의!
			int[] temp = arr.clone();

			st = new StringTokenizer(br.readLine());

			begin = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			mid = Integer.parseInt(st.nextToken()) - 1;

			int cnt = begin;

			//mid부터 end까지를 begin부터 변경
			for(int j = mid; j <= end; j++) {
				arr[cnt] = temp[j];
				cnt++;
			}

			//begin부터 mid전까지 뒤부터 변경
			for(int j = begin; j < mid; j++) {
				arr[cnt] = temp[j];
				cnt++;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}