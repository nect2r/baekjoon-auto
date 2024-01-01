/*
 * @since 2022-11-22
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] arr = new char[M][N];

        for(int i=0; i<M; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int result = cirCoor(arr, M, N);
        System.out.println(result);
    }


    //현재 좌표의 맞닿아있는 네변 방향에 좌표가 있는 값만 해야함
    //좌표가 최상단 왼쪽 구석이면 오른쪽,아래만 있음 || 좌표가 최상단 오른쪽 구석이면 왼쪽,아래만 있음 
    //내용처럼 일단 확인부터해야함                
    //i가 0에 해당하면 위X | i가 마지막에 해당하면 아래X
    //j가 0에 해당하면 왼쪽x | j가 마지막에 해당하면 오른쪽x
    //최초엔 자리를 확인해서 위아래옆을 비교하려 했으나
    //8x8 검은색판 흰색판을 아예 고정해두고 차이를 비교함
    public static int cirCoor(char[][] arr, int M, int N) {
        char[][] Bboard = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
        };

        char[][] Wboard = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
        };

        int result = 0;
        int Bmin = Integer.MAX_VALUE;
        int Wmin = Integer.MAX_VALUE;

        for(int hor = 0; hor <= M - 8; hor++) {
            for(int ver = 0; ver <= N - 8; ver++) {
                char beforeWord = 'N';
                int Bcount = 0;
                int Wcount = 0;

                for(int i = 0 + hor; i < 8 + hor; i++) {
                    for(int j = 0 + ver; j < 8 + ver; j++) {
                        char word = arr[i][j];
                        char Bword = Bboard[i - hor][j - ver];
                        char Wword = Wboard[i - hor][j - ver];

                        if(Bword != word) {
                            Bcount++;
                        }

                        if(Wword != word) {
                            Wcount++;
                        }
                    }
                }

                if(Bcount == 0 || Wcount == 0) {
                    return 0;
                }

                if(Bmin > Bcount) {
                    Bmin = Bcount;
                }

                if(Wmin > Wcount) {
                    Wmin = Wcount;
                }
            }
        };

        if(Bmin > Wmin) {
            result = Wmin;
        } else {
            result = Bmin;
        }

        return result;
    }
}