import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        /**
         *
         *  4 7 8
         *  1  2  3  4  5  6  7  8  9 10 kg
         * -1 -1  1 -1  1  2 -1  2  3  2 최소
         *
         * 11 12 13 14 15 16 17 18 19 20 kg
         *  3  4  3  4  3  4  5  4  5  4 최소
         *
         * 21 22 23 24 25 26 27 28 29 30 kg
         *  5  6  5  6  5  6  7  6  7  6 최소
         *
         * 31 32 33 34 35 36 37 38 39 40 kg
         *  7  8  7  8  7  8  9  8  9  8 최소
         *
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N % 5 == 0){
            System.out.println(N / 5);
        }else if(N < 10) {
            if(N % 3 == 0) System.out.println(N / 3);
            if(N % 3 == 1) System.out.println(-1);
            if(N % 3 == 2) System.out.println(2);
        }else if(N % 5 == 1){
            System.out.println(N / 5 + 1);
        }else if(N % 5 == 2){
            System.out.println(N / 5 + 2);
        }else if(N % 5 == 3){
            System.out.println(N / 5 + 1);
        }else if(N % 5 == 4){
            System.out.println(N / 5 + 2);
        }
    }
}
