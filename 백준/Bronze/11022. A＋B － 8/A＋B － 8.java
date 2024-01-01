import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        
        for(int i=1; i<=T; i++) {
        	Integer A = scanner.nextInt();
        	Integer B = scanner.nextInt();
        	
        	if((0 < A && A < 10) && (0 < B && B < 10)) {
        		System.out.println("Case #" + i + ": " + A + " + " + B + " = " + (A + B));
        	}else {
        		System.out.println("0보다 커야하며 10보다 작아야합니다.");
        	}
        }
        
        scanner.close();
    }
}