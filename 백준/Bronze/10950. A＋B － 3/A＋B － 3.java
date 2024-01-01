import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	Integer T = scanner.nextInt();
    	
    	for(int i=0; i<T; i++) {
    		Integer A = scanner.nextInt();
    		Integer B = scanner.nextInt();
    		
    		if((0 < A) && (B < 10)) {
    			System.out.println(A+B);
    		}else {
    			System.out.println("A는 0보다 커야하며, B는 10보다 작아야합니다.");
    			break;
    		}
    	}
    	
    	scanner.close();
    }
}