import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int cut = Integer.parseInt(st.nextToken());
		int[] intArrays = new int[size];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			intArrays[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<size; i++) {
			int key = intArrays[i];
			int position = i;

			while(position > 0 && key > intArrays[position - 1]) {
				intArrays[position] = intArrays[position - 1];
				position--;
			}

			intArrays[position] = key;
		}

		System.out.println(intArrays[cut-1]);
	}
}