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
		String word = br.readLine();
		//앞과 뒤를 1씩 더하고,빼면서 반대편 포지션에 위치한 char를 가져와 비교한다.
		//최대 반복횟수는 word의 길이 / 2

		boolean check = false;

		for(int i = 0; i < word.length() / 2; i ++) {
			if(word.charAt(i) != word.charAt(word.length() - i - 1)) {
				check = true;
				break;
			}
		}

		if(check) System.out.println("0");
		else System.out.println("1");
	}	
}