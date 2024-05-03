import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String callFunction = br.readLine();
            int lth = Integer.parseInt(br.readLine());

            Deque<Integer> q = new LinkedList<>();

            String line = br.readLine();
            if (lth > 0) {
                String[] array = line.substring(1, line.length() - 1).split(",");

                for (int j = 0; j < lth; j++) {
                    q.add(Integer.parseInt(array[j]));
                }
            }

            boolean isR = false;
            boolean isError = false;

            for (int j = 0; j < callFunction.length(); j++) {
                char Fun = callFunction.charAt(j);

                //뒤집기
                if (Fun == 'R') {
                    isR = !isR;
                } else if (Fun == 'D') {
                    if (q.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }

                    if (isR) {
                        q.pollLast();
                    } else {
                        q.poll();
                    }
                }
            }

            if (isError) {
                continue;
            }

            if (line.equals("[]") || q.isEmpty()) {
                sb.append("[]\n");
            } else if (!q.isEmpty()) {
                sb.append("[");

                boolean isFirst = true;

                while (!q.isEmpty()) {
                    if (!isFirst) {
                        sb.append(",");
                    } else {
                        isFirst = false;
                    }

                    if (isR) {
                        sb.append(q.pollLast());
                    } else {
                        sb.append(q.poll());
                    }
                }

                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}