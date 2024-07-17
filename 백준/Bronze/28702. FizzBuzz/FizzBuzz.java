import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
class Main {

    static int[] sizes = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        for (int i = 3; i > 0; i--) {
            String line = br.readLine();

            if (!line.equals("Fizz") && !line.equals("Buzz") && !line.equals("FizzBuzz")) {
                result = Integer.parseInt(line) + i;
            }
        }

        System.out.println(getResult(result));
    }

    public static String getResult(int result) {
        if (result % 5 == 0 && result % 3 == 0) {
            return "FizzBuzz";
        } else if (result % 5 == 0) {
            return "Buzz";
        } else if (result % 3 == 0) {
            return "Fizz";
        } else {
            return result + "";
        }
    }
}