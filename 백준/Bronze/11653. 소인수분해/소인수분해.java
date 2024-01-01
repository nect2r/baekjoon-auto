import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int M = input.nextInt();

        if(M != 1) {
        	for(int i = 2; i <= M; i++) {
            	if(M % i == 0) {
            		System.out.println(i);
            		M = M / i;
            		i = 1;
            	}
            }
        }
	}
}
