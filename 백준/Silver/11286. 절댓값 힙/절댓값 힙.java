import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> h = new PriorityQueue<>((o1, o2) -> {
            int a1 = Math.abs(o1);
            int a2 = Math.abs(o2);

            if (a1 == a2) {
                return o1 > o2 ? 1 : -1;
            }

            return a1 - a2;
        });

        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());

            if (data == 0) {
                if (h.size() == 0) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(h.poll()).append("\n");
                }
            } else {
                h.add(data);
            }
        }

        System.out.println(sb.toString());
    }
}