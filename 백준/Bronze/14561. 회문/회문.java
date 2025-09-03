import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            result.append(isPalindrome(A, N)).append("\n");
        }

        System.out.println(result);
    }

    public static int isPalindrome(long A, int N) {
        sb.setLength(0);
        sb.append(Long.toString(A, N));

        int len = sb.length() - 1;

        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(len - i)) {
                return 0;
            }
        }

        return 1;
    }
}
