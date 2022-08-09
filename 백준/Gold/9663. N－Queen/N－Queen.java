import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] results;
	static boolean[] select;
	static int n, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cnt = 0;
		results = new int[n];
		select = new boolean[n];

		perm(0);
		System.out.println(cnt);
	}

	public static void perm(int idx) {
		if (idx == n) {
//			System.out.println(Arrays.toString(results));
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			results[idx] = i;
			if (check(idx)) {
				perm(idx + 1);
			}
		}
	}

	public static boolean check(int idx) {
		for (int i = 0; i < idx; i++) {
				if (results[i] == results[idx]||Math.abs(results[i] - results[idx]) == Math.abs( i- idx))
					return false;
			}

	return true;
}}