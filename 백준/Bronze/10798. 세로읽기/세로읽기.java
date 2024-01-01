/*
 * @since 2023-03-02
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] result = new char[15][5];

		//문자열을 입력받으면서 변환
		for(int i = 0; i < 5; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j = 0; j < chars.length; j++) {
				result[j][i] = chars[j];
			}
		}

		StringBuilder sb = new StringBuilder();

		for(char[] cs : result) {
			for(char c : cs) {
				//공백제거 != ' '에서 0으로 검증
				if(c != 0) {
					sb.append(c);
				}
			}
		}

		System.out.println(sb.toString());
	}
}
