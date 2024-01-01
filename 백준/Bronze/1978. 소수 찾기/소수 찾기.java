import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int count = 0;
        
        for(int i = 0; i < size; i++) {
        	int num = input.nextInt();
        	boolean flag = true;
        	for(int j = 2; j < num; j++) {
        		if(num % j == 0) {
        			flag = false;
        		}
        	}
        	if(flag && num != 1) {
        		count++;
        	}
        }
        System.out.println(count);
	}
}
