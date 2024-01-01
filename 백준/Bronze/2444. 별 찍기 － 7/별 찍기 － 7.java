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

public class Main {
	 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 2 * n - 1;
		int start = count / 2;
		int end = start + 1;
		boolean check = false;

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count; j++) {
				if(j >= start && j < end) {
					sb.append("*");
				} else if(j < start){
					sb.append(" ");
				}
			}

			if(end == count) {
				check = true;
			}

			if(check) {
				start++;
				end--;
			} else {
				start--;
				end++;
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}