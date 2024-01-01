import java.util.*;

public class Main {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int count = in.nextInt();
		
		//벌집은 1부터시작
		//1인경우 1
		//2~7 2
		//8~20 3
		//21~37 4
		//범위는 6씩늘어남 
		
		//현재 포지션
		int point = 0;
		
		//이전에 있던 값
		int beforepoint = 1;
		
		//범위를 구하여 들어온 input과 비교하여 알수있을거같음..
		while(true) {
			beforepoint = (6 * point) + beforepoint;
			point++;

			if(beforepoint >= count) {
				System.out.println(point);
				break;
			}
		}
		
	}
}