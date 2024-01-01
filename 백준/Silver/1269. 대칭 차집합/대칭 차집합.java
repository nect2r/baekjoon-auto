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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Acount = Integer.parseInt(st.nextToken());
        int Bcount = Integer.parseInt(st.nextToken());
        int result = 0;

        HashSet<Integer> Aset = new HashSet<>();
        HashSet<Integer> Bset = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Acount; i++) {
            Aset.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Bcount; i++) {
            Bset.add(Integer.parseInt(st.nextToken()));
        }

        Iterator iter = Aset.iterator();
        // B - A
        while(iter.hasNext()) {
            int data = Integer.parseInt(String.valueOf(iter.next()));

            if(!Bset.contains(data)) {
                result++;
            }
        }
        
        iter = Bset.iterator();
        // A - B
        while(iter.hasNext()) {
            int data = Integer.parseInt(String.valueOf(iter.next()));

            if(!Aset.contains(data)) {
                result++;
            }
        }

        System.out.println(result);
    }
}