import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.next();
		int[] arr = { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1 };
		
		for(int i=0; i<word.length(); i++) {
			arr[(int)word.charAt(i)-97] = word.indexOf(word.charAt(i));
		}
		
		for(int a : arr) {
			System.out.print(a + " ");
		}
		
		in.close();
	}
}