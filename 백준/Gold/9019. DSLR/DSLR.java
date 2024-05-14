import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

 */
class Main {

    static boolean[] visit;
    static String[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visit = new boolean[10000];
            prev = new String[10000];
            Arrays.fill(prev, "");

            Queue<Integer> q = new LinkedList<>();

            visit[A] = true;
            q.add(A);

            while (!q.isEmpty() && !visit[B]) {
                int cur = q.poll();

                int D = (cur * 2) % 10000;
                int S = cur == 0? 9999 : cur - 1;
                int L = ((cur % 1000) * 10) + cur / 1000;
                int R = ((cur % 10) * 1000) + cur / 10;

                if (!visit[D]) {
                    q.add(D);
                    visit[D] = true;
                    prev[D] = prev[cur] + "D";
                }

                if (!visit[S]) {
                    q.add(S);
                    visit[S] = true;
                    prev[S] = prev[cur] + "S";
                }

                if (!visit[L]) {
                    q.add(L);
                    visit[L] = true;
                    prev[L] = prev[cur] + "L";
                }

                if (!visit[R]) {
                    q.add(R);
                    visit[R] = true;
                    prev[R] = prev[cur] + "R";
                }
            }

            sb.append(prev[B]).append("\n");
        }

        System.out.println(sb);
    }
}