import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String M = in.next();
		
		if(M.length() <= N) {
			int sum = 0;
			for(int i=0; i<M.length(); i++) {
				 sum += Character.getNumericValue(M.charAt(i));
			}
			System.out.println(sum);
		}
		
		in.close();
	}
}