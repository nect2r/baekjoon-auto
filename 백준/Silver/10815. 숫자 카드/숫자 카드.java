import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCount = Integer.parseInt(br.readLine());
        Map<Integer,Integer> hash = new HashMap();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < nCount; i++) {
            hash.put(Integer.parseInt(st.nextToken()), 1);
        }

        int mCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < mCount; i++) {
            if(hash.containsKey(Integer.parseInt(st.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}