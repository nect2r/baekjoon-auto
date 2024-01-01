/*
 * @since 2022-11-21
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

    static char[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];

        make(0, 0, N, false);

        //출력 변경
        for(char[] c : arr) {
            for(char cs : c) {
                sb.append(cs);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void make(int x, int y, int N, boolean isBlack) {
        if(N == 3) {
            int count = 1;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(isBlack) {
                        arr[i + x][j + y] = ' ';
                    } else {
                        if(count != 5) {
                            arr[i + x][j + y] = '*';
                        } else {
                            arr[i + x][j + y] = ' ';
                        }
                    }
                    count++;
                }
            }
        } else {
            int count = 0;
            int ymove = 0;
            int xmove = 0;

            for(int i = 0; i < 9; i++) {

                if(i != 0) {
                    if(i % 3 == 0) {
                        xmove += N / 3;
                        ymove = 0;
                    } else {
                        ymove += N / 3;
                    }
                }

                if(count == 4 || isBlack) {
                    make(x + xmove, y + ymove, N / 3, true);
                } else {
                    make(x + xmove, y + ymove, N / 3, false);
                }

                count++;
            }
        }
    }
}
