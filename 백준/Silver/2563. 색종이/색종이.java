import java.io.*;

public class Main {

	static int[][] planePoints = new int[100][100];
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		for(int i=0; i<count; i++) {
			String[] strs = br.readLine().split(" ");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			insConfetti(x-1, y-1);
		}

		//평면 출력 예시
		// for(int i=0; i<100; i++) {
		// 	for(int j=0; j<100; j++) {
		// 		System.out.print("" + planePoints[i][j]);
		// 	}
		// 	System.out.println();
		// }

		System.out.println(answer);
	}

	public static void insConfetti(int x, int y) {
		for(int i=x; i<x+10; i++) {
			if(i < 100) {
				for(int j=y; j<y+10; j++) {
					if(j < 100) {
						if(planePoints[i][j] == 0) {
							planePoints[i][j] = 1;
							answer++;
						}
					}
				}
			}
		}
	}
}