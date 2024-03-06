/*
 * @since 2024-03-06
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        dist = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - 48;
                dist[i][j] = -1;
            }
        }
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
        dist[0][0] = 0;
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            // 우 -> 하 -> 좌 -> 상
            for (int i = 0; i < 4; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];
                
                // 미로를 벗어남
                if (px < 0 || px >= M || py < 0 || py >= N) {
                    continue;
                }
                
                // 길이 아니거나 이미 방문함
                if (graph[py][px] == 0 || dist[py][px] != -1) {
                    continue;
                }
                
                q.add(new Pair(px, py));
                dist[py][px] = dist[p.y][p.x] + 1;
            }
        }
        
        System.out.println(dist[N - 1][M - 1] + 1);
    }
    
    public static class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}
