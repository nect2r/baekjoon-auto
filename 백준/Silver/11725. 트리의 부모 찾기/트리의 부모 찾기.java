import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        graph = new LinkedList[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        StringBuilder sb = new StringBuilder();

        dfs(1);

        for (int i = 2; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start) {
        for (int i = 0; i < graph[start].size(); i++) {
            int data = graph[start].get(i);

            if (data != 1 && result[data] == 0) {
                result[data] = start;
                dfs(data);
            }
        }
    }
}
