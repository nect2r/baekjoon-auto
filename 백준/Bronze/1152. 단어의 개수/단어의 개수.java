import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String T = in.nextLine();

		StringTokenizer st = new StringTokenizer(T," ");
		
		System.out.println(st.countTokens());	
		
		in.close();
	}
}