/*
 * @since 2022-11-17
 * User https://www.acmicpc.net/user/nect2r
 * Blog https://nect2r.tistory.com/
 * Github https://github.com/nect2r/BAEKJOON
 * Change the class name to Main
 * Delete the package
 * Run
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstMolecule = Integer.parseInt(st.nextToken());
        int firstDenominator = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int secondMolecule = Integer.parseInt(st.nextToken());
        int secondDenominator = Integer.parseInt(st.nextToken());

        int denominatorGCD = GCD(firstDenominator, secondDenominator);
        int denominatorLCM = LCM(firstDenominator, secondDenominator, denominatorGCD);

        int sumMolecule = (firstMolecule * (denominatorLCM / firstDenominator)) + (secondMolecule * (denominatorLCM / secondDenominator));
        int fountainGCD = GCD(sumMolecule, denominatorLCM);

        System.out.println(sumMolecule / fountainGCD + " " + denominatorLCM / fountainGCD);
    }

    //최대공약수
    private static int GCD(int a, int b) {
        if (b > a) {
            GCD(b, a);
        }

        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }

    //최소공배수
    private static int LCM(int a, int b, int GCD) {
        return a * b / GCD;
    }
}
