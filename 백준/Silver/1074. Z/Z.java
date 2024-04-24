import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, R, C;
    static int cnt = 0;
    static boolean stop = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        partition(0, 0, N);
    }

    public static void partition(int y, int x, int size) {
        if (size == 0 || stop) {
            return;
        }

        if (size == 1) {
            if (y == R && x == C) {
                System.out.println(cnt);
                stop = true;
                return;
            } else {
                cnt++;
            }
        }

        size = size / 2;

        if (R >= y && R < y + size && C >= x && C < x + size) {
            partition(y, x, size);
        } else {
            cnt += size * size;
        }

        if (R >= y && R < y + size && C >= x + size && C < x + size + size) {
            partition(y, x + size, size);
        } else {
            cnt += size * size;
        }

        if (R >= y + size && R < y + size + size && C >= x && C < x + size) {
            partition(y + size, x, size);
        } else {
            cnt += size * size;
        }

        if (R >= y + size && R < y + size + size && C >= x + size && C < x + size + size) {
            partition(y + size, x + size, size);
        } else {
            cnt += size * size;
        }
    }
}