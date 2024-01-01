import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        
        if(0 < N && N <= 100000) {
        	for(int i=N; i > 0; i--) {
        		System.out.println(i);
        	}
        }
        
        scanner.close();
    }
}