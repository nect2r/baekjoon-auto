/*
 * @since 2023-12-26
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
        String line = br.readLine();
        int count = Integer.parseInt(br.readLine());
        
        Stack<Character> first = new Stack<>();
        Stack<Character> second = new Stack<>();
        
        for (int i = 0; i < line.length(); i++) {
            first.add(line.charAt(i));
        }
        
        for (int i = 0; i < count; i++) {
            String text = br.readLine();
            char type = text.charAt(0);
            
            if (type == 'L') {
                if (first.size() > 0) {
                    second.push(first.pop());
                }
            } else if (type == 'D') {
                if (second.size() > 0) {
                    first.push(second.pop());
                }
            } else if (type == 'B') {
                if (first.size() > 0) {
                    first.pop();
                }
            } else {
                char plus = text.charAt(2);
                
                first.push(plus);
            }
        }
        
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!second.isEmpty()) {
            sb.append(second.pop());
        }
        
        System.out.println(sb);
    }
}
