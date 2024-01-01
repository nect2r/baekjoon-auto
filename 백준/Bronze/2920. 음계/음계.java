import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] list = new int[8];

		for(int i = 0; i < list.length; i++) {
		    list[i] = sc.nextInt();
        }
		sc.close();

		String str = "";
		for(int i = 0; i < list.length; i++) {
		    if(i != list.length-1) {
		        if(list[i] == list[i + 1] - 1) {
                    str = "ascending";
                } else if(list[i] == list[i + 1] + 1) {
                    str = "descending";
                } else {
                    str = "mixed";
                    break;
                }
            } else {
		        break;
            }

        }
        System.out.println(str);
	}
}