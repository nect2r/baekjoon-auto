import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Set<String> sets = new HashSet<>();

        for(int i=0; i<size; i++) {
            sets.add(new StringTokenizer(br.readLine()).nextToken());
        }

        String[] result = sets.toArray(new String[0]);

        Arrays.sort(result, (e1, e2) -> {
            if(e1.length() == e2.length()) {
                return e1.compareTo(e2);
            }else{
                return e1.length() - e2.length();
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.length; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);
    }
}