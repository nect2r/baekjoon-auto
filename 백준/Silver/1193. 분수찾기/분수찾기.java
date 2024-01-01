import java.util.*;

public class Main {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int count = in.nextInt();
		
		//입력한 숫자에 맞는 위치에있는 분수를 표출하라 ..
		//너무어려워 ..벌써
		//일단 분모 + 분자 = T라고 할때
		//1/1 이라면 T는 2
		//1/2 그리고 2/1의 T는 3 
		//T가 짝수이면 위에서 아래로 내려가고
		//T가 홀수이면 아래에서 위로 올라가는 방향이된다.
		//그리고 T-1은 해당 대각선칸에 총갯수이다.
		//그러면 count < T-1 일때 해당범위안에 들어온다는 이야기며...
		//count 와 T-1만큼의 차이를 이동하면 해당하는 분수를 찾을수있는듯함
		
		//1/1부터 T는 2이기때문 T를 2로 초기화
		int T = 2;
		//범위
		int Tsum = 0;
		
		while(true) {
			Tsum = Tsum + (T-1);
			
			//범위 안에들면
			if(count <= Tsum) {
				//범위에서 몇칸쨰인지 찾기위함
				int point = Tsum-count;
				
				//짝수면 아래로
				//홀수면 위로
				if(T % 2 == 0) {
					//짝수는 무조건 1/n 으로 시작하기
					System.out.println((1+point) + "/" + ((T-1)-point));
				}else {
					//홀수는 무조건 n/1 으로 시작하기
					System.out.println((T-1)-point + "/" + (1+point));
				}
				
				break;
			}
			T++;
		}
	}
}