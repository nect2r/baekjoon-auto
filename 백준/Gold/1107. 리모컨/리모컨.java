import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
class Main {

    static boolean[] btn = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());

                btn[b] = true;
            }
        }

        int min = Math.abs(100 - N);

        for (int i = 0; i < 999999; i++) {
            String current = String.valueOf(i);
            boolean check = false;

            for (int j = 0; j < current.length(); j++) {
                if (btn[current.charAt(j) - 48]) {
                    check = true;
                }
            }

            if (!check) {
                min = Math.min(min, Math.abs(i - N) + current.length());
            }
        }

        System.out.println(min);
    }
}