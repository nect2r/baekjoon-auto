import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int mod = 9;
        int i = 1;
        int cnt = 0;

        while (true) {
            if (n > mod) {
                n = n - mod;
                cnt += mod * i;
                mod = mod * 10;
                i++;
            } else {
                cnt += n * i;
                break;
            }
        }

        System.out.println(cnt);
    }
}