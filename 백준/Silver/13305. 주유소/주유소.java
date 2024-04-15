import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] road = new int[N];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
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