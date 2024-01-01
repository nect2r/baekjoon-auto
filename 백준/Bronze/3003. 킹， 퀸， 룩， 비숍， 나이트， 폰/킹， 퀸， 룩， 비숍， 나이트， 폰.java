import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");

		System.out.println((1-Integer.parseInt(strs[0])) + " " + (1-Integer.parseInt(strs[1])) + " " + (2-Integer.parseInt(strs[2])) + " " + (2-Integer.parseInt(strs[3])) + " " + (2-Integer.parseInt(strs[4])) + " " + (8-Integer.parseInt(strs[5])));
	}
}