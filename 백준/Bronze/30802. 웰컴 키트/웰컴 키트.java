import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
class Main {

    static int[] sizes = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int resultT = 0;
        int resultP = 0;
        int resultPr = 0;

        for (int i = 0; i < sizes.length; i++) {
            resultT += Math.ceil((double) sizes[i] / T);
        }

        resultP = (int) Math.floor((double) N / P);
        resultPr = N % P;

        System.out.println(resultT);
        System.out.println(resultP + " " + resultPr);
    }
}