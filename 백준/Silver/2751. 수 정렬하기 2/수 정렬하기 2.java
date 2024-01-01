import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		Integer[] numbers = new Integer[size];

		for(int i=0; i<size; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(numbers);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i=0; i<size; i++) {
			bw.write(numbers[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}