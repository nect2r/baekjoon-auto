import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] graph = new int[H + 1][N + 1][M + 1];
        int[][][] dist = new int[H + 1][N + 1][M + 1];
        int[] dM = {1, -1, 0, 0, 0, 0};
        int[] dN = {0, 0, 1, -1, 0, 0};
        int[] dH = {0, 0, 0, 0, 1, -1};

        Queue<Pair> q = new LinkedList<>();
        
        int resultCount = 0;
        int zeroCount = 0;
        int zeroMCount = 0;
        
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                
                for (int k = 1; k <= M; k++) {
                    int data = Integer.parseInt(st.nextToken());
                    
                    graph[i][j][k] = data;
                    if (data == 1) {
                        q.add(new Pair(k, j, i));
                    } else if (data == 0) {
                        zeroCount++;
                    }
                }
            }
        }
        
        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            
            for (int i = 0; i < 6; i++) {
                int pM = p.m + dM[i];
                int pN = p.n + dN[i];
                int pH = p.h + dH[i];
                
                if (pM <= 0 || pN <= 0 || pH <= 0 || pM > M || pN > N || pH > H) {
                    continue;
                }
                
                if (dist[pH][pN][pM] != 0 || graph[pH][pN][pM] != 0) {
                    continue;
                }
                
                q.add(new Pair(pM, pN, pH));
                dist[pH][pN][pM] = dist[p.h][p.n][p.m] + 1;
                
                if (resultCount < dist[pH][pN][pM]) {
                    resultCount = dist[pH][pN][pM];
                }
                zeroMCount++;
            }
        }
        
        if (zeroMCount == zeroCount) {
            System.out.println(resultCount);
        } else {
            System.out.println(-1);
        }
    }

    public static class Pair {
        int m, n, h;
        Pair (int m, int n, int h) {
            this.m = m;
            this.n = n;
            this.h = h;
        }
    }
}
