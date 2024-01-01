import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        scanner.close();
        
        if(1 <= N && N <= 9) {
        	for(int i=1; i <= 9; i++) {
            	System.out.println(N + " * " + i + " = " + N*i);
            }
        }else {
        	System.out.println("입력할 N은 1보다 크거나 같고, 9보다 작거나 같아야합니다.");
        }
    }
}