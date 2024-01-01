import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());

        System.out.println(Fac(N));
	}

	public static int Fac(int i) {
        if(i == 0){
            return 1;
        }

        return i * Fac(i - 1);
    }
}