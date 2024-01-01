import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int hour = input.nextInt();
        int minet = input.nextInt();
        int plusMinet = input.nextInt();
    
        hour = hour + plusMinet / 60;
        minet = minet + plusMinet % 60;
        if(minet >= 60){
            hour++;
            minet = minet - 60;
        }
        if(hour >= 24) {
        	hour = hour - 24;
        }
        System.out.println(hour + " " + minet);
    }
}