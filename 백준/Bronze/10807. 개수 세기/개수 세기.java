import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String size = bf.readLine();
		String[] strs = bf.readLine().split(" ");
		String search = bf.readLine();
		int chk = 0;

		for(int i=0; i<strs.length; i++) {
			if(search.equals(strs[i])) {
				chk++;
			}
		}

		System.out.println(chk);

	}
}