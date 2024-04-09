import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] words = br.readLine().toCharArray();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                sb.append(words[j]);
            }
            list.add(sb.toString());
            sb = new StringBuilder();
        }

        Collections.sort(list);

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}