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
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < count; i++) {
            int data = Integer.parseInt(st.nextToken());
            
            stack.push(data);
            if (max < data) {
                max = data;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        int[] temp = new int[max + 1];
        int[] result = new int[count];
        int point = count;
        
        while (!stack.isEmpty()) {
            point--;
            
            if (prev == 0) {
                result[point] = -1;
                prev = stack.pop();
            } else {
                int current = stack.pop();
                
                if (current < prev) {
                    result[point] = prev;
                    temp[current] = prev;
                    prev = current;
                } else {
                    int prevTemp = prev;
                    
                    while (current >= temp[prevTemp]) {
                        prevTemp = temp[prevTemp];
                        if (prevTemp == 0) {
                            result[point] = -1;
                            prev = current;
                            break;
                        }
                    }
                    
                    if (current < temp[prevTemp]) {
                        result[point] = temp[prevTemp];
                        temp[current] = temp[prevTemp];
                        prev = current;
                    }
                }
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + " ");
        }
        
        System.out.println(sb.toString().trim());
    }
}