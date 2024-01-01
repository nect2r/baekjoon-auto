import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();
        //제 1사분면
        if(A > 0 && B > 0){
            System.out.println("1");
        //제 4사분면
        }else if(A > 0 && B < 0){
            System.out.println("4");
        //제 3사분면
        }else if(A < 0 && B < 0){
            System.out.println("3");
        //제 2사분면
        }else if(A < 0 && B > 0){
            System.out.println("2");
        }
    }
}