import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] days = new int[N];
        int[] costs = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            days[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        int max = Integer.MIN_VALUE;

        for (int i = N - 1; i >= 0; i--) {
            int diff = N - (i + days[i]);
            int prev = 0;

            if (i != N - 1) {
                prev = result[i + 1];
            }

            if (diff == 0) {
                result[i] = Math.max(costs[i], prev);
            } else if (diff > 0) {
                result[i] = Math.max(costs[i] + result[i + days[i]], prev);
            } else {
                result[i] = prev;
            }

            if (max < result[i]) {
                max = result[i];
            }
        }

        System.out.println(max);
    }
}