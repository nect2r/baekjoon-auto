import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxNumber = 0;
		int x = 0;
		int y = 0;

		for(int i=0; i<9; i++) {
			String[] strs = br.readLine().split(" ");

			for(int j=0; j<strs.length; j++) {
				if(maxNumber < Integer.parseInt(strs[j])) {
					maxNumber = Integer.parseInt(strs[j]);
					x = i;
					y = j;
				}
			}
		}
		System.out.println(maxNumber);
		System.out.println(x+1 + " " + (y+1));
	}
}