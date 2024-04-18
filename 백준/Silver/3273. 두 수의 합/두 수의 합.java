import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int result = 0;
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == X) {
                result++;
                left++;
            } else if (sum > X) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);
    }
}