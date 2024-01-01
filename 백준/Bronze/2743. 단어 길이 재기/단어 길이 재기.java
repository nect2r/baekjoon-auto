import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String strs = bf.readLine();

		System.out.println(strs.length());
	}
}