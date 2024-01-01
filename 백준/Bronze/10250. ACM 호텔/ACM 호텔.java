import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
 
		int T = in.nextInt();
 
		for(int i = 0; i < T; i++) {
			
			int H = in.nextInt();
			int W = in.nextInt();
			int N = in.nextInt();
			
            //N과 H의 나머지가 0이면
            //층수가 N이라는것 EX) 6 % 6 이면 0이므로 
            //해당층수는 6층임 
            //표기를 하려면 601호부터 시작하기때문에 * 100을함
            
            //그러면 거리는...?
            //거리는 N/H 또는 (N/H)+1 임
            //6/6을 통해서 1이나오기때문에
            //601호가 완성됨
            
            //근데 7 % 6 이되면..?
            //else 를 타고 나머지인 1이나옴
            // 1 * 100 하면 100이 되서 1층인걸 알수있고
            // 7/6을 하게되면 1+1 이되서
            // 102호임을 알수있음
			if(N % H == 0) {
				System.out.println((H * 100) + (N / H));
 
			} else {
				System.out.println(((N % H) * 100) + ((N / H) + 1));
			}
		}
	}
}