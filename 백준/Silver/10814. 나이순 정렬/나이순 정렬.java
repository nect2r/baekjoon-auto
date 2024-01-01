import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String[][] strs = new String[size][2];

		StringTokenizer st;
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());																				
			strs[i][0] = st.nextToken();
			strs[i][1] = st.nextToken();
		}

		Arrays.sort(strs, (e1, e2) -> {
			int a = Integer.parseInt(e1[0]);
			int b = Integer.parseInt(e2[0]);
			return a - b;
		}) ;

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			sb.append(strs[i][0] + " " + strs[i][1] + "\n");
		}
		System.out.println(sb.toString());
	}
}