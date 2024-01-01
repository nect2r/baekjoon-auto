import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int answer = 0;
        int minX = 0;
        int minY = 0;

        if(x < w - x) {
            minX = x;
        }else{
            minX = w - x ;
        }

        if(y < h - y) {
            minY = y;
        }else{
            minY = h - y ;
        }

        if(minX > minY) {
            answer = minY;
        }else{
            answer = minX;
        }

        System.out.println(answer);
    }
}