/*
 * @since 2024-03-04
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
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<Integer>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        graph = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph[p][c] = graph[c][p] = 1;
        }
        
        //dfs
        printDfs(S);
        sb.append("\n");
        check = new boolean[N + 1];
        
        //bfs
        printBfs(S);
        
        //출력
        System.out.println(sb);
    }
    
    static void printDfs(int start) {
        check[start] = true;
        sb.append(start).append(" ");
        
        for (int i = 1; i< graph.length; i++) {
            if (graph[start][i] == 1 && !check[i]) {
                printDfs(i);
            }
        }
    }
    
    static void printBfs(int start) {
        queue.add(start);
        check[start] = true;
        
        while(!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start).append(" ");
            
            for (int i = 1; i < graph.length; i++) {
                if (graph[start][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
