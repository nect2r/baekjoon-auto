import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int i=0; i<T; i++) {
			int R = in.nextInt();
			String S = in.next();
			String P = "";
			
			for(int x=0; x<S.length(); x++) {
				for(int j=0; j<R; j++) {
					P = P + S.charAt(x);
				}
			}
			
			System.out.println(P);
		}
		
		in.close();
	}
}