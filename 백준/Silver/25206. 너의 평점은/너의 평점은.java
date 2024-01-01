/*
 * @since 2023-03-01
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String,Double> map = new HashMap<>();

		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		map.put("P", 0.0);

		double s = 0;
		double q = 0;

		for(int i = 0; i < 20; i ++) {
			st = new StringTokenizer(br.readLine());

			//과목명 사용할곳 없음
			st.nextToken();
			Double n = Double.parseDouble(st.nextToken());
			String m = st.nextToken();

			s += n * map.get(m);

			if(!m.equals("P")) {
				q += n;
			}
		}

		double avg = s / q;
		System.out.printf("%.6f\n", avg);
	}	
}