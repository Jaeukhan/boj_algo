import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int swit[] = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println("init" + Arrays.toString(swit));
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sexual = Integer.parseInt(st.nextToken()), num = Integer.parseInt(st.nextToken());
			if (sexual == 1) {// man
				for (int j = 1; j < swit.length; j++) {
					if (j % num == 0) {
						int ch = (swit[j] == 0) ? 1 : 0;
						swit[j] = ch;
					}
				}
			} else {// woman
				int ch = (swit[num] == 0) ? 1 : 0;
				swit[num] = ch;
				for (int j = 1; j < swit.length / 2; j++) {
					if (num - j < 1 || num + j >= n + 1)
						break;
					if (swit[num - j] == swit[num + j]) {
						ch = (swit[num - j] == 0) ? 1 : 0;
						swit[num - j] = ch;
						ch = (swit[num + j] == 0) ? 1 : 0;
						swit[num + j] = ch;
					}

					else
						break;

				}
			}
		}
		for (int j = 1; j < n+1; j++) {
			System.out.print(swit[j] + " ");
			if(j%20==0)
				System.out.println();
		}
	}
}