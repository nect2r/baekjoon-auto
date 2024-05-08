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

        int start = 0;
        int end = target.length();
        int lth = line.length();

        int result = 0;

        while (start + end <= lth) {
            boolean isCheck = true;

            for (int i = 0; i < end; i++) {
                if (line.charAt(start + i) != target.charAt(i)) {
                    if (i == 0) {
                        start++;
                    } else {
                        int next = pi[i - 1] == 0 ? 1 : pi[i - 1];
                        start += next;
                    }

                    isCheck = false;
                    break;
                }
            }

            if (isCheck) {
                result++;
                start += 2;
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