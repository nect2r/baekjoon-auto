import java.io.*;
import java.util.*;

public class Main {

    static int point = 0;
    static int count = 1;
    static int answer = -1;
    static int[] arr,tmp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        point = Integer.parseInt(st.nextToken());

        arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tmp = new int[size];

        merge_sort(0, arr.length - 1);

        System.out.println(answer);
    }

    public static void merge_sort(int p, int r) {
        if(count > point) return;
        if(p < r) {
            int q = (p + r) / 2;
            merge_sort(p, q);
            merge_sort(q + 1, r);
            if(answer == -1) {
                merge(p, q, r);
            }else{
                return;
            }
        }
    }

    public static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if(arr[i] <= arr[j]) {
                tmp[t] = arr[i];
                t++;
                i++;
            } else {
                tmp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= q) {
            tmp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= r) {
            tmp[t] = arr[j];
            t++;
            j++;
        }  

        i = p; 
        t = 0;

        while (i <= r) {
            arr[i] = tmp[t];
            if(count == point) {
                answer = arr[i];
                break;
            } else {
                count++;
            }
            i++;
            t++;
        }
    }
}