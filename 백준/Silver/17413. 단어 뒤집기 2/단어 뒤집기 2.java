/*
 * @since 2023-12-31
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        Deque<Character> chars = new ArrayDeque<>();
        boolean check = false;

        for (int i = 0; i < line.length(); i++) {
            char data = line.charAt(i);

            if (data == '<') {
                while (!chars.isEmpty()) {
                    sb.append(chars.pop());
                }

                check = true;
                sb.append(data);
            } else if (data == '>') {
                check = false;
                sb.append(data);
            } else {
                if (check) {
                    sb.append(data);
                } else {
                    if (data == ' ') {
                        while (!chars.isEmpty()) {
                            sb.append(chars.pop());
                        }
                        sb.append(" ");
                    } else {
                        chars.push(data);
                    }
                }
            }
        }

        while (!chars.isEmpty()) {
            sb.append(chars.pop());
        }

        System.out.println(sb);
    }
}
