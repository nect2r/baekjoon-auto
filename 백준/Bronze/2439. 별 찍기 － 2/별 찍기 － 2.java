import java.util.Scanner;

public class Main {
	public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        
        if(1 <= T && T <= 100) {
        	String star = "*";
        	
			for(int i=1; i<=T; i++) {
				String space = "";
				for(int j=1; j<=T-i; j++) {
					space = space + " ";
				}
				System.out.println(space + star);
				star = star + "*";
			}
        }
        scanner.close();
    }
}