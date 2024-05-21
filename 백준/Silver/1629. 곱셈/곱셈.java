import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

 */
class Main {

    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(make(A, B) % C);
    }

    public static long make(long A, long B) {
        if (B == 1) {
            return A;
        }

        long temp = make(A, B / 2);

        if (B % 2 == 0) {
            return temp * temp % C;
        }

        return (temp * temp % C) * A % C;
    }
}