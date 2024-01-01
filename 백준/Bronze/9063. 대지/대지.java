import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 점의 개수
        int count = Integer.parseInt(st.nextToken());
        
        // 4개의 최댓값 필요
        // 가장작은 x, 가장큰 x
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        // 가장작은 y, 가장작은 y
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(minX > x) {
                minX = x;
            }

            if(maxX < x) {
                maxX = x;
            }

            if(minY > y) {
                minY = y;
            }

            if(maxY < y) {
                maxY = y;
            }
        };

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
