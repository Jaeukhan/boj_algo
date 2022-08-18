import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char map[][];
	static int[] dj = { 1, 1, 1 };
	static int[] di = { -1, 0, 1 };
	static int ans, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		ans = 0;
		for (int i = 0; i < r; i++) {
			String txt = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = txt.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			if (map[i][0] == '.') {
				map[i][0]='x';
				if (dfs(i, 0)) {
					ans++;
				}
			}
		}
		System.out.println(ans);

	}

	static boolean dfs(int i, int j) {
		if (j == c - 1) {
			return true;
		}
		for (int d = 0; d < 3; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < r && 0 <= nj && nj < c && map[ni][nj] == '.' ) {
				map[i][j] = 'x';
				if (dfs(ni, nj))
					return true;
			}
		}
		return false;
	}
}