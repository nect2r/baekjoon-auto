/*
 * @since 2024-03-17
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

    static int[][] graph;
    static boolean[][] visit;

    static int[] dh = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dw = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //종료
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h][w];
            visit = new boolean[h][w];
            Queue<Node> q = new LinkedList<>();

            int count = 1;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    int data = Integer.parseInt(st.nextToken());

                    graph[i][j] = data;
                    if (data == 1) {
                        //큐에 넣기
                        q.add(new Node(i, j));
                    }
                }
            }

            Queue<Node> subQ = new LinkedList<>();

            int result = 0;

            while(!q.isEmpty()) {
                if (subQ.isEmpty()) {
                    Node mainQ = q.poll();

                    if (visit[mainQ.h][mainQ.w]) {
                        continue;
                    }

                    subQ.add(mainQ);
                    result++;
                }

                Node node = subQ.poll();

                for (int i = 0 ; i < 8; i++) {
                    int ph = node.h + dh[i];
                    int pw = node.w + dw[i];

                    if (ph < 0 || pw < 0 || ph >= h || pw >= w) {
                        continue;
                    }

                    //방문 및 벽이아닌경우
                    if (visit[ph][pw] || graph[ph][pw] == 0) {
                        continue;
                    }

                    subQ.add(new Node(ph, pw));
                    visit[ph][pw] = true;

                    //System.out.println("parent : " + node.h + ", " + node.w + "/ child : " + ph + ", " + pw);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static class Node {
        int h;
        int w;

        Node (int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
