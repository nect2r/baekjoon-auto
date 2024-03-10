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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] visit = new int[100001];

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);

        while(!q.isEmpty()) {
            int current = q.poll();

            int plus = current + 1;
            if (plus < visit.length && plus != start && visit[plus] == 0) {
                q.add(plus);
                visit[plus] = visit[current] + 1;
            }

            int minus = current - 1;
            if (minus >= 0 && minus != start && visit[minus] == 0) {
                q.add(minus);
                visit[minus] = visit[current] + 1;
            }

            int multi = current * 2;
            if (multi < visit.length && multi != start && visit[multi] == 0) {
                q.add(multi);
                visit[multi] = visit[current] + 1;
            }
        }

        System.out.println(visit[end]);
    }
}
