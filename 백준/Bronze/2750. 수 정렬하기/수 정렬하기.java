import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] arrys = new int[count];

		for(int i=0; i<count; i++) {
			arrys[i] = Integer.parseInt(br.readLine());
		}

		for(int i=1; i<arrys.length; i++) {
			int key = arrys[i];
			int position = i;

			while(position > 0 && key < arrys[position - 1]) {
				arrys[position] = arrys[position - 1];
				position--;
			}

			arrys[position] = key;
		}

		for(int i=0; i<count; i++) {
			System.out.println(arrys[i]);
		}
	}
}