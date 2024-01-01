import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        while(count > 0) {
            st = new StringTokenizer(br.readLine());

            int firstSize = Integer.parseInt(st.nextToken());
            int[] first = new int[4];

            for(int i = 0; i < firstSize; i++) {
                int point = Integer.parseInt(st.nextToken());

                first[point - 1]++;
            }

            st = new StringTokenizer(br.readLine());
            int secondSize = Integer.parseInt(st.nextToken());
            int[] second = new int[4];

            for(int i = 0; i < secondSize; i++) {
                int point = Integer.parseInt(st.nextToken());

                second[point - 1]++;
            }

            printSb(first, second);
            count--;
        }

        System.out.println(sb.toString());
    }

    public static void printSb(int[] a, int[] b) {
        int point = 3;

        while(point != -1) {
            if(a[point] == b[point]) {
                if(point == 0) {
                    sb.append("D\n");
                    break;
                }
            } else if(a[point] > b[point]) {
                sb.append("A\n");
                break;
            } else {
                sb.append("B\n");
                break;
            }

            point--;
        }
    }
}