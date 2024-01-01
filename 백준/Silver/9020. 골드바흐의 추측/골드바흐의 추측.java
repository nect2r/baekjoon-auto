import java.util.*;

public class Main {
	
	static boolean[] isPrime = new boolean[20001];
	
	public static void main(String[] args) {
		make_Prime();
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		while(T-- > 0) {
			int N = sc.nextInt();
			
			int T1 = N / 2;
			int T2 = N / 2;
			
			while(true) {
				if(!isPrime[T1] && !isPrime[T2]) {
					System.out.print(T1);
					System.out.print(" ");
					System.out.print(T2 + "\n");
					break;
				} else {
					T1 = T1 - 1;
					T2 = T2 + 1;
				}
			}
		}
	}
	
	static void make_Prime() {
		isPrime[0] = isPrime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(isPrime.length); i ++) {
			if(isPrime[i]) continue;
			for(int j = i * i; j < isPrime.length; j += i) {
				isPrime[j] = true;
			}
		}
	}
}