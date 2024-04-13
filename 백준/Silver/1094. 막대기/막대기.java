import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int size = 64;

        while (n > 0) {
            if (size > n) {
                size /= 2;
            } else {
                cnt++;
                n -= size;
            }
        }

        System.out.println(cnt);
    }
}