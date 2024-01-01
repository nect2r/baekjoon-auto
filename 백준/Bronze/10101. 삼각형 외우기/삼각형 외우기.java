import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int y = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int z = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        if(x % 60 == 0 && y % 60 == 0 && z % 60 == 0) {
            System.out.println("Equilateral");
        } else if(180 == x + y + z && (x == y || x == z || y == z)) {
            System.out.println("Isosceles");
        } else if(180 == x + y + z) {
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }
    }
}
