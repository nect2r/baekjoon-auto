import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String binaryString = st.nextToken();		
		int binaryType = Integer.parseInt(st.nextToken());

		//결과
		int result = 0;
		//거듭제곱
		int powLevel = binaryString.length() - 1;
		int point = 0;

		while(powLevel >= 0) {
			int data = (int)binaryString.charAt(point);

			// 1~9 => 48을 뺌
			// A~Z => 55를 뺌
			if(data >= 65) {
				data = data - 55;
			} else {
				data = data - 48;
			}

			// pow로 자릿수만큼 거듭제곱함
			result += data * Math.pow(binaryType, powLevel);

			powLevel--;
			point++;
		}

		System.out.println(result);
	}
}