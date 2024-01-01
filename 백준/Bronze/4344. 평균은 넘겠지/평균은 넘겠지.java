import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//테스트 케이스 N개
		int N = in.nextInt();
		
		for(int i=0; i<N; i++) {
			//인원수 
			int people = in.nextInt();
			
			//점수 배열
			int[] point = new int[people];
			
			//총점수
			int sum = 0;
			double count = 0;
			
			for(int j=0; j<people; j++) {
				point[j] = in.nextInt();
				sum += point[j];
			}
			
			for(int j=0; j<people; j++) {
				if(sum/people < point[j]) {
					count++;
				}
			}
			
			System.out.println(String.format("%.3f", (count/people)*100) + "%");
		}
		in.close();
	}
}