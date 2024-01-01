import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String strs = bf.readLine();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<strs.length(); i++) {
			char a = strs.charAt(i);

			if(a > 96 && a < 123){
				sb.append(Character.toUpperCase(a));
			}else{
				sb.append(Character.toLowerCase(a));
			}
		}

		System.out.println(sb.toString());
	}
}