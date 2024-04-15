import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[] road = new long[N];
        long[] cost = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                result += road[i] * cost[i];
            } else {
                if (cost[i] > cost[i - 1]) {
                    cost[i] = cost[i - 1];
                }

                result += road[i] * cost[i];
            }
        }

        System.out.println(result);
    }
}