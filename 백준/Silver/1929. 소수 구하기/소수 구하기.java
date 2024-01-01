import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = Integer.parseInt(sc.next());
		int N = Integer.parseInt(sc.next());
		int i;
		boolean arr[] = new boolean[N+1];
		arr[0] = arr[1] = true;
        
		int sqrt = (int) Math.sqrt(N);
		for(i=2; i<=sqrt; i++) {

			for(int j=2; j<=N/i; j++) {
					if(arr[i*j] == true) {
						continue;
					}
					else  {
						arr[i*j] = true;
					}
			}	
		}

		for(i=M; i<=N; i++) {
			if(arr[i] == false) {
				System.out.println(i);
			}
		}
	}
}
