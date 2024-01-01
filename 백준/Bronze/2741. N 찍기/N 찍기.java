import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        
        if(0 < N && N <= 100000) {
        	for(int i=1; i<=N; i++) {
        		System.out.println(i);
        	}
        }
        
        scanner.close();
    }
}