import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 의상의 수
            HashMap<String, Integer> clothes = new HashMap<>(); // <의상 유형, 의상의 개수>

            for(int i=0; i<n; i++){
                String type = br.readLine().split(" ")[1]; // 의상의 유형
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for(int val : clothes.values()){
                answer *= (val+1);
            }

            sb.append(answer - 1).append("\n"); // 가져다 입을 수 있는 의상 조합의 수
        }

        System.out.println(sb);
        br.close();
    }
}