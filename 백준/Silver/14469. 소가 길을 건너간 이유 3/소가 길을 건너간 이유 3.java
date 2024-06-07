import java.io.*;
import java.util.*;

/*

 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int[][] data = new int[T][2];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            data[i][0] = N;
            data[i][1] = M;
        }

        Arrays.sort(data, (a, b) -> a[0] - b[0]);

        int max = 0;

        for (int i = 0; i < T; i++) {
            if (max >= data[i][0]) {
                max += data[i][1];
            } else {
                max = data[i][0] + data[i][1];
            }
        }

        System.out.println(max);
    }
}