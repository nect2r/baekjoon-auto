/*
 * @since 2023-03-07
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
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(String.valueOf(br.readLine()));

		Queue<Integer> queue = new LinkedList<>();

		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while(queue.size() > 1) {
			queue.remove();
			queue.add(queue.remove());
		}

		System.out.println(queue.remove());
	}
}
