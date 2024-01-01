import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String T = in.nextLine();
		
		char[] str = T.toCharArray();
		int time = 0;
		
		for(char c : str) {
			switch (c) {
			case 'A': case 'B': case 'C':
				time += 3;
				break;
			case 'D': case 'E': case 'F':
				time += 4;
				break;
			case 'G': case 'H': case 'I':
				time += 5;
				break;
			case 'J': case 'K': case 'L':
				time += 6;
				break;
			case 'M': case 'N': case 'O':
				time += 7;
				break;
			case 'P': case 'Q': case 'R': case 'S':
				time += 8;
				break;
			case 'T': case 'U': case 'V':
				time += 9;
				break;
			case 'W': case 'X': case 'Y': case 'Z':
				time += 10;
				break;
			default:
				break;
			}
		}
		
		System.out.println(time);
		
		in.close();
	}
}