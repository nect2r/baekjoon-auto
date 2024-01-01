import java.util.*;

public class Main {
	static Scanner in = new Scanner(System.in);
	 
	public static void main(String[] args) {
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		
		if(B >= C) {
			System.out.println("-1");
		}else {
			System.out.println(A/(C-B) + 1);
		}
		
		in.close();
	}
}