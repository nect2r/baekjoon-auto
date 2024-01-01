/*
 * @since 2021-12-01
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */
import java.util.*;

public class Main {
	static Scanner in = new Scanner(System.in);
	 
	public static void main(String[] args) {
 
		int count = 0;
		int N = in.nextInt();
 
		for (int i = 0; i < N; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}
 
	public static boolean check() {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = in.next();
		
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);
			
			if (prev != now) {		
				
				if ( check[now - 'a'] == false ) {
					check[now - 'a'] = true;
					prev = now;				
				}
	 
				else {
					return false;	
				}
			}
	        
			else {
				continue;
			}
		}    
		return true;
	}
}