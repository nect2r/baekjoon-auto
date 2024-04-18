import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        arr = new int[X];
        result = new int[X];
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < X; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < X; i++) {
            result[i] = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    result[i] = Math.max(result[i], arr[i] + result[j]);
                }
            }

            if (max < result[i]) {
                max = result[i];
            }
        }

        System.out.println(max);
    }
}