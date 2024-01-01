import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] list = new int[N];
		
		for(int i=0; i<N; i++) {
			list[i] = in.nextInt();
		}
		
		in.close();
		Arrays.sort(list);
		System.out.println(list[0] + " " + list[N - 1]);
	}
}