import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();

		for(int i=1; i<c.length; i++) {
			int value = c[i];
			int position = i;

			while(position > 0 && value > c[position - 1]) {
				c[position] = c[position - 1];
				position--;
				c[position] = (char) value;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(char s : c) {
			sb.append(s);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}