import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String N = in.next();
		char M = N.charAt(0);
		
		if((M >= 48 && M <= 57) || (M >= 65 && M <= 90) || (M >= 97 && M <= 122)) {
			System.out.println((int)M);
		}
		
		in.close();
	}
}