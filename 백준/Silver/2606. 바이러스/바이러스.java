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
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int nodes = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[nodes + 1][nodes + 1];
        boolean[] visit = new boolean[nodes + 1];
        
        for (int i = 0; i < lines; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            
            graph[p1][p2] = graph[p2][p1] = 1;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        
        int result = 0;
        
        while(!q.isEmpty()) {
            int start = q.poll();
            visit[start] = true;
            
            for (int i = 1; i < nodes + 1; i++) {
                if (graph[start][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    result ++;
                }
            }
        }
        
        System.out.println(result);
    }
}
