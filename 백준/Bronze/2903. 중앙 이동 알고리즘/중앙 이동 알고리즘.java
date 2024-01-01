/*
 * @since 2023-05-02
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		//초기 사각형의 갯수
		int square = 4;
		double sqrt = 0.0;

		for(int i = 0; i < N; i++) {
			sqrt = Math.sqrt(square) + 1;
			square = square * 4;
		}

		System.out.println((int)(sqrt * sqrt));

		// 풀이법을 진짜 모르겠다가
		// 예제를 역행하다보니
		// 3 * 3 9 = 2 * 2 = 4
		// 5 * 5 25 = 4 * 4 = 16
		// 9 * 9 81 = 8 * 8 = 64
		// 17 * 17 289 = 16 * 16 = 256
		// 33 * 33 1089 = 32 * 32 = 1024
		// 수식만 찾게됨.. 우항의 제곱근에 1만 더해서 곱하면 출력은 할수있음..
		// 풀어보고 보니까 진행되는 제곱의 차를 보면 1,2,4,8로 진행되는데 
		// 공식을 알았으면 더쉽게 했을걸..
		// 공식
		// 총 점의 개수 = (2^n + 1)^2 => (2의 n승 + 1)의 제곱
		// -> 2의 0승은 1인데, 초기는 2가 나와야하고
		// -> 2의 1승은 2인데, 첫번째는 3이 나와야해서 +1을 해주었다.
		// System.out.println(Math.pow(Math.pow(2, N) + 1, 2));
	}
}