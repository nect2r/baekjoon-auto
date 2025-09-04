import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start = 1;

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            for (int j = 1; j < A + B; j++) {
                if (start == 4) {
                    start = 1;
                } else {
                    start++;
                }
            }
        }

        System.out.println(start);
    }
}
