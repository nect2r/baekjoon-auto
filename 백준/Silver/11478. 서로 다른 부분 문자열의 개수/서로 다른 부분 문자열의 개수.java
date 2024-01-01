/*
 * @since 2023-01-03
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
        String str = br.readLine();

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            for(int j = 1; j <= str.length(); j++) {
                if(j + i <= str.length()) {
                    set.add(str.substring(j - 1, j + i));
                }
            }
        }

        System.out.println(set.size());
    }
}