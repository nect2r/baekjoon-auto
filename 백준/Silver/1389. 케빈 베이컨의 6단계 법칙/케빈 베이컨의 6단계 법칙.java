import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

5 5
1 3
1 4
4 5
4 3
3 2

 */
class Main {

    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjList[s].add(e);
            adjList[e].add(s);
        }

        int[] result = new int[N + 1];
        int min = 0;

        for (int i = 1; i <= N; i++) {
            int[] dist = new int[N + 1];

            Queue<Integer> q = new LinkedList<>();

            q.add(i);

            while (!q.isEmpty()) {
                int s = q.poll();

                for (int e : adjList[s]) {
                    if (dist[e] == 0 && e != i) {
                        dist[e] = dist[s] + 1;
                        result[i] += dist[e];
                        q.add(e);
                    }
                }
            }

            if (min == 0 || result[min] > result[i]) {
                min = i;
            }
        }

        System.out.println(min);
    }
}