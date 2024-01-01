/*
 * @since 2022-11-17
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int[] items = new int[count];

        //1. 가로수의 위치별 차이를 구한다.
        //2. 모든 차이의 최대공약수를 구한다.
        //3. 마지막 가로수까지 최대공약수에 해당하는 자리를 채운다.

        //가로수의 위치별 차이
        Set<Integer> diff = new HashSet<>();

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            items[i] = Integer.parseInt(st.nextToken());

            //두번째 가로수부터 이전 가로수와의 차이를 구함
            if (i != 0) {
                diff.add(items[i] - items[i - 1]);
            }
        }


        //가로수의 최대공약수를 정리함
        while (diff.size() != 1) {
            Set<Integer> diffGCD = new HashSet<>();

            Iterator iter = diff.iterator();
            int prev = 0;

            while (iter.hasNext()) {
                if (prev == 0) {
                    prev = (int)iter.next();
                } else {
                    diffGCD.add(GCD((int)iter.next(), prev));
                }
            }

            diff = diffGCD;
        }

        int first = items[0];
        int last = items[items.length - 1];

        //추가해야할 간격이 되는 가로수들의 최대공약수
        int diffGCD = 0;

        Iterator iter = diff.iterator();
        while (iter.hasNext()) {
            diffGCD = (int)iter.next();
        }

        int plusCount = 0;

        for (int i = first + diffGCD; i <= last; i+= diffGCD) {
            plusCount++;
        }

        //추가해서 완성된 가로수의 갯수 - 기존 가로수
        System.out.println(plusCount - items.length + 1);
    }

    private static int GCD(int first, int second) {
        if (second > first) {
            return GCD(second, first);
        }

        if (second == 0) {
            return first;
        }

        return GCD(second, first % second);
    }
}
