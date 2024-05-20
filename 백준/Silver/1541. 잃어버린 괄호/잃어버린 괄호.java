import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

 */
class Main {

    static int[] items = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int idx =0;
        int start = 0;
        for (int i = 1; i <= line.length(); i++) {
            if (i == line.length() || line.charAt(i) == '-' || line.charAt(i) == '+') {
                items[idx] = Integer.parseInt(line.substring(start, i));
                
                start = i;
                idx++;
            }
        }
        
        int result = items[0];
        for (int i = 1; i < idx + 1; i++) {
            int sum = items[i];
            
            if (sum < 0) {
                int j = i;
                while (items[++j] > 0) {
                    sum += -items[j];
                    i++;
                }
            }
            result += sum;
        }

        System.out.println(result);
    }
}