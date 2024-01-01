import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		int[] result = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			result[i] = a;
		}

		Arrays.sort(arr);

		Map<Integer,Integer> map = new HashMap();

		int count = 0;
		for(int i=0; i<size; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], count);
				count++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			sb.append(map.get(result[i]) + " ");
		}

		System.out.println(sb);
	}
}