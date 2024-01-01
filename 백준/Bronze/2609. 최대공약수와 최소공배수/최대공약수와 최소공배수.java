import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        System.out.println(gdc(first, second));
        System.out.println(lcm(first, second));
    }

    //최대공약수
    public static int gdc(int first, int second) {

        //큰걸 기준으로 mod 해야하기 때문에 변환함
        if(first < second) {
            int temp = first;
            first = second;
            second = temp;
        }

        //mod 값이 0이 될때까지 진행
        while(second != 0) {
            int mod = first % second;
            first = second;
            second = mod;
        }

        //0이 아닌 나머지를 보면 최대공약수가 됨
        return first;
    }

    //최소공배수
    public static int lcm(int first, int second) {
        return first * second / gdc(first, second);
    }
}