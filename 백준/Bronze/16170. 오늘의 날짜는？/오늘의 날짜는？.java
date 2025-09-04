import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = zonedDateTime.getYear();
        int month = zonedDateTime.getMonthValue();
        int day = zonedDateTime.getDayOfMonth();

        bw.write(year + "\n");
        bw.write(month < 10 ? "0" + month + "\n" : month + "\n");
        bw.write(day < 10 ? "0" + day : day + "");
        bw.flush();
        bw.close();
    }
}
