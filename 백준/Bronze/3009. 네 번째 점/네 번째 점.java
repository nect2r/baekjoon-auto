/*
 * @since 2022-11-17
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
        StringTokenizer st = null;

        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        int resultX = 0;
        int resultY = 0;

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            xPoints[i] =  Integer.parseInt(st.nextToken());
            yPoints[i] = Integer.parseInt(st.nextToken());
        }

        if(xPoints[0] == xPoints[1]) {
            resultX = xPoints[2];
        } else if(xPoints[0] == xPoints[2]) {
            resultX = xPoints[1];
        } else {
            resultX = xPoints[0];
        }

        if(yPoints[0] == yPoints[1]) {
            resultY = yPoints[2];
        } else if(yPoints[0] == yPoints[2]) {
            resultY = yPoints[1];
        } else {
            resultY = yPoints[0];
        }

        System.out.println(resultX + " " + resultY);
    }
}