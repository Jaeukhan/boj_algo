import java.util.Scanner;

public class Main {
	static int n;
	static boolean[] select;
	static int ans;
	static Favor[] fb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ans = 1_000_000_000-1;
		fb = new Favor[n];
		select = new boolean[n];
		for (int i = 0; i < n; i++) {
			fb[i] = new Favor(sc.nextInt(), sc.nextInt());
		}
		for (int i = 1; i <= n; i++) {
			comb(0, 0, i);
		}
		System.out.println(ans);
	}

	public static void comb(int idx, int cnt, int m) {
		if (cnt == m) {
			long sums = 1, sumb = 0;
			for (int i = 0; i < select.length; i++) {
				if (select[i]) {
					sums *= fb[i].s;
					sumb += fb[i].b;
				}
			}
//			System.out.println(Math.abs((int) (sums-sumb)));
			ans = Math.min(ans, Math.abs((int) (sums-sumb)));
			return;
		}
		if (idx == n)
			return;
		select[idx] = true;
		comb(idx + 1, cnt + 1, m);
		select[idx] = false;
		comb(idx + 1, cnt, m);
	}

	public static class Favor {
		int s, b;

		public Favor() {
		}

		public Favor(int s, int b) {
			this.s = s;
			this.b = b;
		}

	}
}