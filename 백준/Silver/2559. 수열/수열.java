import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= K - 1; i--) {
            int sum = 0;
            int cnt = 0;

            for (int j = i; cnt < K && j >= 0; j--) {
                cnt++;
                sum += arr[j];
            }

            if (i < N - 1) {
                arr[i] = Math.max(sum, arr[i + 1]);
            } else {
                arr[i] = sum;
            }
        }

        System.out.println(arr[K - 1]);
    }
}