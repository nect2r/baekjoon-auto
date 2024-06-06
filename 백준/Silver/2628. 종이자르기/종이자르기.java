/*
 * @since 2023-10-23
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        x.add(N);
        y.add(M);

        int C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            if (type == 1) {
                x.add(point);
            } else {
                y.add(point);
            }
        }

        Collections.sort(x);
        Collections.sort(y);

        int result = 0;
        int prevX = 0;

        for (int i = 0; i < x.size(); i++) {
            int prevY = 0;

            int dX = x.get(i) - prevX;

            for (int j = 0; j < y.size(); j++) {
                int dY = y.get(j) - prevY;

                prevY = y.get(j);

                if (result < dX * dY) {
                    result = dX * dY;
                }
            }

            prevX = x.get(i);
        }

        System.out.println(result);
    }
}
