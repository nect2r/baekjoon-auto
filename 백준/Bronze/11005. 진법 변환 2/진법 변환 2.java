import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int binaryString = Integer.parseInt(st.nextToken());
		int binaryType = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		while(true) {
			int quotient = binaryString / binaryType;
			int remainder = binaryString % binaryType;

			// 10부터 A-> char변환 55더하기
			if(remainder >= 10) {
				sb.append((char)(remainder + 55));
			} else {
				sb.append(remainder);
			}

			if(binaryType > binaryString) {
				break;
			}

			binaryString = quotient;
		}

		System.out.println(sb.reverse().toString());
	}
}