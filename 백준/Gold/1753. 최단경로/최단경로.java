/*
 * @since 2024-03-10
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        List<Pair>[] list = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Pair(v, w));
        }

        boolean[] visit = new boolean[V + 1];
        int[] dist = new int[V + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();

            //if (visit[p.v]) continue;
            //visit[p.v] = true;

            for (Pair ps : list[p.v]) {
                if (dist[ps.v] > dist[p.v] + ps.w) {
                    dist[ps.v] = dist[p.v] + ps.w;
                    pq.add(new Pair(ps.v, dist[ps.v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static class Pair implements Comparable<Pair>{
        int v;
        int w;

        Pair (int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.w == o.w) {
                return Integer.compare(this.v, o.v);
            } else {
                return Integer.compare(this.w, o.w);
            }
        }
    }
}
