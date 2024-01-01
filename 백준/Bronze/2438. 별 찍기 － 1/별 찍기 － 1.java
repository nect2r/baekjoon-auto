import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        
        if(1 <= T && T <= 100) {
        	String star = "*";
        	
			for(int i=1; i<=T; i++) {
				System.out.println(star);
				star = star + "*";
			}
        }
        scanner.close();
    }
}