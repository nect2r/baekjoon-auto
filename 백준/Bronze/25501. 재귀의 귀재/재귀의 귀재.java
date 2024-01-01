import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            System.out.println(isPalindrome(str) + " " + count);
            count = 0;
        }

        System.out.println(sb);
    }

    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}