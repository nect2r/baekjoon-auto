import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

 */
class Main {

    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        StringBuilder sb = new StringBuilder("I");

        for (int i = 0; i < N; i++) {
            sb.append("OI");
        }

        String target = sb.toString();

        getPi(target);

        int lth = line.length();
        int result = 0;

        int j = 0;
        for (int i = 0; i < lth; i++) {
            while (j > 0 && target.charAt(j) != line.charAt(i)) {
                j = pi[j - 1];
            }

            if (target.charAt(j) == line.charAt(i)) {
                if (j == target.length() - 1) {
                    result++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        System.out.println(result);
    }

    static void getPi(String line) {
        pi = new int[line.length()];

        int j = 0;

        for (int i = 1; i < line.length(); i++) {
            while (j > 0 && line.charAt(j) != line.charAt(i)) {
                j = pi[j - 1];
            }

            if (line.charAt(j) == line.charAt(i)) {
                pi[i] = ++j;
            }
        }
    }
}