import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*

 */
class Main {

    static int[] arr;
    static int[][] cost = new int[16][16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // mbti별 거리
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (i != j) {
                    cost[i][j] = Integer.bitCount(i ^ j);
                }
            }
        }

        int count = Integer.parseInt(br.readLine());

        for (int cnt = 0; cnt < count; cnt++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();

            arr = new int[16];

            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();

                int pointer = 0;

                for (int j = 0; j < 4; j++) {
                    char c = mbti.charAt(j);

                    pointer = pointer << 1;
                    if (c == 'E' || c == 'S' || c == 'F' || c == 'J') {
                        pointer++;
                    }
                }

                if (arr[pointer] < 3) {
                    arr[pointer]++;
                    list.add(pointer);
                }
            }

            int lth = list.size();
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < lth; i++) {
                for (int j = 0; j < lth; j++) {
                    for (int k = 0; k < lth; k++) {
                        if (i != j && j != k && i != k) {
                            int s1 = list.get(i);
                            int s2 = list.get(j);
                            int s3 = list.get(k);

                            int sum = cost[s1][s2] + cost[s2][s3] + cost[s1][s3];

                            if (sum < min) {
                                min = sum;
                            }
                        }
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}