/*
 * @since 2023-05-06
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
    
        Stack stack = new Stack();

        // 명령의 수
        int n = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String eventType = st.nextToken();

            switch (eventType) {
                case "push" : {
                    int data = Integer.parseInt(st.nextToken());
                    stack.push(data);
                    break;
                }
                case "pop" : {
                    stack.pop();
                    break;
                }
                case "size" : {
                    stack.size();
                    break;
                }
                case "empty" : {
                    stack.empty();
                    break;
                }
                case "top" : {
                    stack.top();
                    break;
                }
            }

            eventType = null;
        }   
    }
}

class Stack {
    List<Integer> stack = new ArrayList<>();

    public void push(int data) {
        stack.add(data);
    }

    public void pop() {
        if(stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.get(stack.size() - 1));
            stack.remove(stack.size() - 1);
        }
    }

    public void size() {
        System.out.println(stack.size());
    }

    public void empty() {
        if(stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public void top() {
        if(stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.get(stack.size() - 1));
        }
    }
}