import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        Map<String,Boolean> map = new HashMap<>();

        for(int i=0; i<N; i++) {
            map.put(br.readLine(), false);
        }

        for(int i=0; i<M; i++) {
            if(map.containsKey(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}