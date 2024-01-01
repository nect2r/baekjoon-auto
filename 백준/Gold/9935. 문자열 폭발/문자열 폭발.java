import java.io.*;
import java.util.*;

public class Main{

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] removeChars = br.readLine().toCharArray();
        
        Deque<Character> result = new ArrayDeque<>();
        
        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            result.push(c);
            
            Deque<Character> prevStack = new ArrayDeque<>();
            
            for (int j = 0; j < removeChars.length; j++) {
                boolean backup = false;
                
                if (!result.isEmpty()) {
                    char r = result.pop();
                    prevStack.push(r);
                    char rC = removeChars[j];
                    
                    if (rC != r) {
                        backup = true;
                    }
                } else {
                    backup = true;
                }
                
                if (backup) {
                    while (!prevStack.isEmpty()) {
                        result.push(prevStack.pop());
                    }
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (result.isEmpty()) {
            sb.append("FRULA");
        } else {
            while (!result.isEmpty()) {
                sb.append(result.pop());
            }
        }
        
        System.out.println(sb);
    }
}