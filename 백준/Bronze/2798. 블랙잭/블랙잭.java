import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE;
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                for(int h=0; h<size; h++) {
                    if(i != j && j != h && i != h) {
                        int sum = arr[i] + arr[j] + arr[h];
                        if(max >= sum && answer < sum) {
                            answer = sum;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}