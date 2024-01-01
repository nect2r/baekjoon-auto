import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        //영어로 된 문제라 너무어려움..
        //일단 최선을 다해봅니다.
        //크리스마스 시즌이라 트리문제로 특별하게 풀게됐어요. 화이팅~

        //일단 해석되기론
        //텔레마케터 번호인지를 구별하는 속성이
        //7자리 수 중 뒤에 4자리로 구분하는데
        //1. 첫번쨰 번호가 8 또는 9
        //2. 마지막 번호가 8 또는 9
        //3. 두번쨰,세번째 번호가 같음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int third = Integer.parseInt(br.readLine());
        int fourth = Integer.parseInt(br.readLine());
        boolean isTel = true;


        if(first != 8 && first != 9) {
            isTel = false;
        } else if(fourth != 8 && fourth != 9) {
            isTel = false;
        } else if(second != third) {
            isTel = false;
        }

        print(isTel);

    }

    public static void print(boolean isTel) {
        if(isTel) {
            System.out.println("ignore");
        } else {
            System.out.println("answer");
        }
    }
}