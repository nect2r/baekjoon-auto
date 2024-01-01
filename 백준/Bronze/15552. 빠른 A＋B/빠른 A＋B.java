import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
    	
    	try {
    		
    		Integer T = Integer.parseInt(bf.readLine());
    		
    		if(T <= 1000000) {
    			for(int i=0; i<T; i++) {
    				String str = bf.readLine();
    				Integer A = Integer.parseInt(String.valueOf(str.subSequence(0, str.indexOf(" "))));
    				Integer B = Integer.parseInt(String.valueOf(str.subSequence(str.indexOf(" ")+1, str.length())));
    				
    				if((1 <= A && A <= 1000) && (1 <= B && B <= 1000)) {
    					Integer sum = A + B;
    					bw.write(String.valueOf(sum));
    					bw.newLine();
    				}
    			}
    		}else {
    			System.out.println("T는 최대 1,000,000 입니다.");
    		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bw.flush();
			
			bf.close();
			bw.close();
		}
    }
}