import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = 0;
        int B = Integer.parseInt(br.readLine());

        for (int i = 0; i < 90; i++) {
            A += 100;

            if (A + A * 0.1 == B) {
                System.out.println(A);
                break;
            }
        }
    }
}
