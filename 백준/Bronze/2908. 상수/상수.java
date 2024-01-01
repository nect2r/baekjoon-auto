import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String T1 = in.next();
		String T2 = in.next();
		
		int a,b = 0;
		
		StringBuffer sb1 = new StringBuffer(T1);
		a = Integer.parseInt(sb1.reverse().toString());
		StringBuffer sb2 = new StringBuffer(T2);
		b = Integer.parseInt(sb2.reverse().toString());
		
		if(a > b) {
			System.out.println(a);
		}else {
			System.out.println(b);
		}
		
		
		in.close();
	}
}