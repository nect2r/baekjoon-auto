import java.util.*;

public class Main {
	
	static boolean[] isPrime = new boolean[123456 * 2 + 1];
	
	public static void main(String[] args) {
		make_Prime();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int N = Integer.parseInt(sc.next());
			if(N == 0) {
				break;
			} else {
				int count = 0;
				
				for(int i = N+1; i <= N * 2; i++) {
					if(!isPrime[i]) count++;
				}
				System.out.println(count);
			}
		}
	}
	
	static void make_Prime() {
		isPrime[0] = isPrime[1] = true;
		
		for(int i = 2; i < Math.sqrt(isPrime.length); i ++) {
			if(isPrime[i]) continue;
			for(int j = i * i; j < isPrime.length; j += i) {
				isPrime[j] = true;
			}
		}
	}
}