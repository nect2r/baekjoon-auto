import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=N; i>0; i--) {
            int size = String.valueOf(N).length();
            int tmp = i;
            int sum = 0;

            sb.setLength(0);
            for(int j=0; j<size; j++) {
                sb.append(tmp % 10);
                sum += tmp % 10;
                tmp = tmp / 10;
            }

            sb.reverse();
            int value = Integer.parseInt(sb.toString());
            if((sum + value) == N) {
                if(answer > i || answer == 0) {
                    answer = i;
                }
            }
        }

        System.out.println(answer);
    }
}