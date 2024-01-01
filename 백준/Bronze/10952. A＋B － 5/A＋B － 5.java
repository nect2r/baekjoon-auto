import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	Integer A,B;
    	
    	while(true) {
    		A = scanner.nextInt();
    		B = scanner.nextInt();
    		
    		if((A == 0 && B == 0)) {
    			break;
    		}else if((0 < A && A < 10) && (0 < B && B < 10)) {
    			System.out.println(A+B);
    		}else {
    			break;
    		}
    	}
    	
        scanner.close();
    }
}