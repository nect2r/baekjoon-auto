import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        
        //시
        Integer hour = Integer.parseInt(String.valueOf(A.subSequence(0, A.indexOf(" "))));
        //분
        Integer minute = Integer.parseInt(String.valueOf(A.subSequence(A.indexOf(" ")+1, A.length())));
        if((0 > hour || hour > 23) || (0 > minute || minute > 59)) {
        	System.out.println("시간이 옳바르지 안습니다.");
        }else {
        	//뺴야하는 분
            Integer minusMinute = 45;
            
            //만약 분끼리 뻇을떄 minus해야하는 대상이 더크면 시간도 뺴야하기때문
            if(minute < minusMinute) {
            	hour = hour-1;
            	minute = (minute+60) - minusMinute;
            }else {
            	minute = minute - minusMinute;
            }
            
            if(hour < 0) {
            	hour = hour + 24;
            }
            System.out.println(hour + " " + minute);
        }
    }
}