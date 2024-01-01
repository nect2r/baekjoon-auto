import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int avg = 0;
		int middle = 0;
		int[] arrys = new int[5];

		for(int i=0; i<5; i++) {
			arrys[i] = Integer.parseInt(br.readLine());
			avg += arrys[i];
		}

		for(int i=1; i<5; i++) {
			int key = arrys[i];
			int position = i; 

			while(position > 0 && key < arrys[position - 1]) {
				arrys[position] = arrys[position - 1];
				position--;
			}

			arrys[position] = key;
		}

		System.out.println(avg / 5);
		System.out.println(arrys[2]);
	}
}