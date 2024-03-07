/*
 * @since 2024-03-07
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
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<Pair> q = new LinkedList<Pair>();
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
                
                if (board[i][j] == 1) {
                    q.add(new Pair(j, i));
                }
            }
        }
        
        Queue<Pair> subQ = new LinkedList<Pair>();
        List<Integer> result = new ArrayList<Integer>();
        
        Pair qp = q.poll();
        subQ.add(qp);
        visit[qp.y][qp.x] = true;
        int houseCount = 0;
        
        while(!q.isEmpty()) {
            if (subQ.isEmpty()) {
                qp = q.poll();
                
                if (!visit[qp.y][qp.x]) {
                    subQ.add(qp);
                    visit[qp.y][qp.x] = true;
                    result.add(houseCount);
                    houseCount = 0;
                } else {
                    continue;
                }
            }
            Pair p = subQ.poll();
            houseCount++;
            
            for (int i = 0; i < 4; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];
                
                if (px < 0 || px >= N || py < 0 || py >= N) {
                    continue;
                }
                
                if (board[py][px] == 0 || visit[py][px]) {
                    continue;
                }
            
                subQ.add(new Pair(px, py));
                visit[py][px] = true;
            }
        }
        result.add(houseCount);
        
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        
        sb.append(result.size());
        for (int r : result) {
            sb.append("\n").append(r);
        }
        
        System.out.println(sb);
    }
    
    public static class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
