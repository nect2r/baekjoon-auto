import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        while(true) {
            b -= c;
            d -= a;

            if (b <= 0 && d <= 0) {
                System.out.println("DRAW");
                break;
            } else if (d <= 0) {
                System.out.println("PLAYER A");
                break;
            } else if (b <= 0) {
                System.out.println("PLAYER B");
                break;
            }
        }
    }
}
