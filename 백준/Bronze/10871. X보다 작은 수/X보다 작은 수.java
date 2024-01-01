import java.util.Scanner;

public class Main {
	public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        Integer X = scanner.nextInt();
        Integer[] list = new Integer[N];
        
        if((1 <= N && N <= 10000) && (1 <= X && X <= 10000)) {
            for(int i=0; i<N; i++) {
            	Integer A = 	scanner.nextInt();
            	list[i] = A;
            }
            
            for(Integer C : list) {
            	if(X > C) {
            		System.out.print(C + " ");
            	}
            }
        }
        
        scanner.close();
    }
}