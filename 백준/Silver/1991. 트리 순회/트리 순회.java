import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
class Main {

    static char[][] nodes = new char[26][2];
    static boolean[] visit = new boolean[26];

    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static StringBuilder sb3 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();

            nodes[input.charAt(0) - 65][0] = input.charAt(2);
            nodes[input.charAt(0) - 65][1] = input.charAt(4);
        }

        visit[0] = true;
        DFS('A');

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
    }

    static void DFS(char start) {
        if (start == '.') {
            return;
        }

        char[] cur = nodes[start - 65];
        char left = cur[0];
        char right = cur[1];

        sb1.append(start);

        if (left != '.' && !visit[left - 65]) {
            visit[left - 65] = true;
            DFS(left);
            sb2.append(start);
        } else {
            sb2.append(start);
        }

        if (right != '.' && !visit[right - 65]) {
            visit[right - 65] = true;
            DFS(right);
            sb3.append(start);
        } else {
            sb3.append(start);
        }
    }
}