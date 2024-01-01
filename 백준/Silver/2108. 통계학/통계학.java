import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int median = 10000;
		int mode = 10000;

		for(int i=0; i<size; i++) {
			int value = Integer.parseInt(br.readLine());
			sum += value;
			arr[value + 4000]++;

			if(max < value) {
				max = value;
			}
			if(min > value) {
				min = value;
			}
		}

		int count = 0; //중앙값 빈도 누적
		int mode_max = 0; //최빈값 최댓값

		boolean flag = false;

		for(int i = min + 4000; i <= max + 4000; i++) {
			if(arr[i] > 0) {
				if(count < (size + 1) / 2) {
					count += arr[i];
					median = i - 4000;
				}

				if(mode_max < arr[i]) {
					mode_max = arr[i];
					mode = i - 4000;
					flag = true;
				}else if(mode_max == arr[i] && flag == true) {
					mode = i - 4000;
					flag = false;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf((int)Math.round((double)sum / size)) + "\n");
		bw.write(String.valueOf(median) + "\n");
		bw.write(String.valueOf(mode) + "\n");
		bw.write(String.valueOf(max - min));
		bw.flush();
		bw.close();
	}
}