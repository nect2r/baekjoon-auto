import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = bf.readLine().split(" ");
		long a = Integer.parseInt(strs[0]);
		long b = Integer.parseInt(strs[1]);

		System.out.println((a+b)*(a-b));
	}
}