/*
 * @since 2023-03-03
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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		while(true) {
			st = new StringTokenizer(br.readLine());
			int data = Integer.parseInt(st.nextToken());

			// -1의 경우 중단
			if(data == -1) {
				break;
			} else {
				System.out.println(make(data).toString());
			}
		}
	}

	public static StringBuilder make(int data) {
		StringBuilder sb = new StringBuilder();
		sb.append(data + "");

		//완전수는 자신을 제외한 합이여야 하므로.. 굳이 data길이 만큼은 안돌아도될듯
		//약수가 2가 존재한다면 그게 자기자신 다음 약수일테니까.. 2길이만 하면되나?

		int sum = 0;

		for(int i = 1; i <= data / 2; i++) {
			if(data % i == 0) {
				sum += i;
				if(i == 1) {
					sb.append(" = " + i);
				} else {
					sb.append(" + " + i);
				}
			}
		}

		if(sum != data) {
			sb = new StringBuilder();
			sb.append(data + " is NOT perfect.");
		}

		return sb;
	}
}
