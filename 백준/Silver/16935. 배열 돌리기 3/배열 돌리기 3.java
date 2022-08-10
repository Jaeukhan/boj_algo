import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int n, m, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (r == 1) {
			int opt = Integer.parseInt(br.readLine());
			calc(opt);
		} else {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < r; i++) {
				int opt = Integer.parseInt(st.nextToken());
				calc(opt);
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void rightrotate(int n, int m) {
		int[][] tmp = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[j][n - 1 - i] = map[i][j];// n m
			}
		}
		map = new int[m][n];
		map = tmp.clone();
	}

	static void leftroate(int n, int m) {
		int[][] tmp = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[m - 1 - j][i] = map[i][j];
			}
		}
		map = new int[m][n];
		map = tmp.clone();
	}

	static void calc(int opt) {
		int tmp[][];
		if (opt == 1) {
			int tn = map.length, tm = map[0].length;
			tmp = new int[tn][tm];
			for (int i = tn - 1; i >= 0; i--) {
				for (int j = 0; j < tm; j++) {
					tmp[tn - 1 - i][j] = map[i][j];
				}
			}
			map = tmp.clone();
		} else if (opt == 2) {
			int tn = map.length, tm = map[0].length;
			tmp = new int[tn][tm];
			for (int i = 0; i < tn; i++) {
				for (int j = tm - 1; j >= 0; j--) {
					tmp[i][tm - 1 - j] = map[i][j];
				}
			}
			map = tmp.clone();
		} else if (opt == 3) {
			rightrotate(map.length, map[0].length);

		} else if (opt == 4) {
			leftroate(map.length, map[0].length);

		} else if (opt == 5) {
			int tn = map.length, tm = map[0].length;
			tmp = new int[tn][tm];
			for (int i = 0; i < tn / 2; i++) {
				for (int j = 0; j < tm / 2; j++) {
					tmp[i][j + tm / 2] = map[i][j];
					tmp[i + tn / 2][j + tm / 2] = map[i][j + tm / 2];
					tmp[i + tn / 2][j] = map[i + tn / 2][j + tm / 2];
					tmp[i][j] = map[i + tn / 2][j];
				}
			}
			map = tmp.clone();

		} else if (opt == 6) {
			int tn = map.length, tm = map[0].length;
			tmp = new int[tn][tm];
			for (int i = 0; i < tn / 2; i++) {
				for (int j = 0; j < tm / 2; j++) {
					tmp[i][j] = map[i][j + tm / 2];
					tmp[i][j + tm / 2] = map[i + tn / 2][j + tm / 2];
					tmp[i + tn / 2][j + tm / 2] = map[i + tn / 2][j];
					tmp[i + tn / 2][j] = map[i][j];
				}
			}
			map = tmp.clone();

		}
	}

}