/*
 * @since 2023-03-08
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(String.valueOf(br.readLine()));

        for(int i = 0; i < count; i++) {
            String str = br.readLine();

            if(VPS(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean VPS(String str) {
        Deque<Integer> deque = new ArrayDeque<>();

        // (:40, ):41
        int a = 0;
        int b = 0;

        for(int i = 0; i < str.length(); i++) {
            deque.add((int)str.charAt(i));
        }

        if(deque.getFirst() == 41 || deque.getLast() == 40) {
            return false;
        }

        while(deque.size() > 0) {
            Integer temp = deque.poll();

            if(temp == 40) {
                a++;
            } else {
                b++;
                if(a != 0) {
                    a--;
                    b--;
                }
            }

        }

        if(a == 0 && b == 0) {
            return true;
        }

        return false;
    }
}
