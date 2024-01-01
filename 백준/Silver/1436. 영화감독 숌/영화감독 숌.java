import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int check = 1;
        int point = 666;

        while(true) {
            if(count == check) {
                System.out.println(point);
                break;
            } else {
                point++;
                String str = String.valueOf(point);

                if(str.contains("666")) {
                    check++;
                }
            }
        }
    }
}