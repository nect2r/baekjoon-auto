import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//첫번쨰 input은 과목의 갯수 N개
		int N = in.nextInt();
		
		
		//두번쨰 input은 과목 성적 N개 만큼
		double[] M = new double[N];
		
		//최고점수 H
		double H = 0;

		//과목의 점수를 저장하면서 최고점수도 갱신함
		for(int i=0; i<N; i++) {
			M[i] = in.nextInt();
			if(M[i] > H) {
				H = M[i];
			}
		}
		
		//총점수 SUM
		double sum = 0;
		
		//최고점수로 배열의 전체점수를 다시넣음
		for(int i=0; i<M.length; i++) {
			M[i] = M[i]/H*100;
			sum += M[i];
		}
		
		//결과
		System.out.println(sum/M.length);
		in.close();
	}
}