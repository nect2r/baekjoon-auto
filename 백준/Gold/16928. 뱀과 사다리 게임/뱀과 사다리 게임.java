import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] dist = new int[101];
    static int[] skip = new int[101];
    static int[] back = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N + M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (i < N) {
                skip[s] = e;
            } else {
                back[s] = e;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == 100) {
                break;
            }

            for (int i = 1; i < 7; i++) {
                int next = current + i;

                if (next <= 0 || next > 100) {
                    continue;
                }

                if (skip[next] != 0) {
                    int skipDist = dist[skip[next]];
                    int currDist = dist[current] + 1;

                    if (skipDist == 0 || skipDist >= currDist) {
                        dist[skip[next]] = currDist;
                        q.add(skip[next]);
                    }
                } else if (back[next] != 0) {
                    int backDist = dist[back[next]];
                    int currDist = dist[current] + 1;

                    if (backDist == 0 || backDist >= currDist) {
                        dist[back[next]] = currDist;
                        q.add(back[next]);
                    }
                } else {
                    if (dist[next] == 0 || dist[next] > dist[current] + 1) {
                        dist[next] = dist[current] + 1;
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(dist[100]);
    }
}