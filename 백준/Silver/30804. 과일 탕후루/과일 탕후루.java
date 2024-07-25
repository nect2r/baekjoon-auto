import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
class Main {

    static int[] arr;
    static int[] kind = new int[10];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        move(0,0,0,0);
        System.out.println(max);
    }

    public static void move(int l, int r, int k, int s) {
        if (r >= arr.length || r < 0 || l >= arr.length || l < 0) {
            return;
        }

        int p = arr[r];
        if (kind[p] == 0 && k == 2) {
            while (k >= 2 && l < r) {
                int lP = arr[l];
                kind[lP]--;

                if (kind[lP] == 0) k--;
                l++;
                s--;
            }
        }

        if (kind[p] == 0) k++;
        kind[p]++;
        s++;

        max = max > s ? max : s;
        move(l, r + 1, k, s);
    }
}