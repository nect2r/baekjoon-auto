import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        List<stu> list = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            short kor = Short.parseShort(st.nextToken());
            short eng = Short.parseShort(st.nextToken());
            short math = Short.parseShort(st.nextToken());

            stu s = new stu(name, kor, eng, math);
            list.add(s);
        }

        Collections.sort(list);

        for (stu s : list) {
            sb.append(s.name).append("\n");
        }

        System.out.println(sb);
    }
}
class stu implements Comparable<stu> {
    String name;
    short kor;
    short eng;
    short math;

    public stu(String name, short kor, short eng, short math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(stu o) {
        if (this.kor - o.kor != 0) {
            return o.kor - this.kor;
        } else if (this.eng - o.eng != 0) {
            return this.eng - o.eng;
        } else if (this.math - o.math != 0) {
            return o.math - this.math;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}