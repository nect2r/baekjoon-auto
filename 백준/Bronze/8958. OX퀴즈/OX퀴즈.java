import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//1차 시도에서 결과를 뿌려줄떄 for문을 쓰지않고 
		//다더하자마자 출력하는 방식으로 줄였음
		//점수를 담는 배열도 사라짐
		
		Scanner in = new Scanner(System.in);
		
		//첫번쨰 input 테스트 케이스 N개
		int N = in.nextInt();
		
		//OX를 담는 배열
		String[] ox = new String[N];
		
		for(int i=0; i<N; i++) {
			ox[i] = in.next();
		}
		
		//점수
		int sum;
		//연계점수
		int and;
		
		//테스트 케이스만큼 돔
		for(int i=0; i<N; i++) {
			sum = 0;
			and = 1;
			String str = ox[i];
			//String 을 char로 변환하고 O인경우에는 점수를 더하고 +1을하여서 연계점수를 늘림
			//틀린경우에는 연계점수를 1로 초기화
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == 'O') {
					sum += and;
					and++;
				}else if(str.charAt(j) == 'X') {
					and = 1;
				}
			}
			System.out.println(sum);
		}
		
		in.close();
	}
}