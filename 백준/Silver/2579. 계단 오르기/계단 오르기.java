import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dp;
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        array = new int[count + 1];
        dp = new Integer[count + 1];

        for (int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];
        dp[1] = array[1];

        if (count >= 2) {
            dp[2] = array[1] + array[2];
        }

        System.out.println(make(count));
    }

    public static int make(int count) {

        if (dp[count] == null) {
            dp[count] = Math.max(make(count - 2), make(count - 3) + array[count - 1]) + array[count];
        }

        return dp[count];
    }
}
