import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int itemCount = Integer.parseInt(br.readLine());
        int realTotal = 0;
        
        for(int i=0; i<itemCount; i++) {
            String[] strs = br.readLine().split(" ");
            String item = strs[0];
            String cnt = strs[1];

            realTotal += Integer.parseInt(item) * Integer.parseInt(cnt);
        }

        if(total == realTotal) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}