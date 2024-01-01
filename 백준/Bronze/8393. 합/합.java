import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer count = 0;
        
        if(1 <= n && n <= 10000) {
        	for(int i=1; i<=n; i++) {
        		count = count + i;
        	}
        }else {
        	System.out.println("n은 1보다 크거나 같아야하며, 10000보다 작거나 같아야합니다.");
        }
        
        System.out.println(count);
    }
}