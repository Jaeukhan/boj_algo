import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { 0, 0, -1 ,1};
	static int[] dj = { -1, 1, 0, 0 };//
	static int r, c, cnt;
	static char map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cnt = 0;
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String txt = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = txt.charAt(j);
			}
		}
		String t = Character.toString(map[0][0]);
		dfs(0, 0, t);
		System.out.println(cnt);
	}

	private static void dfs(int i, int j, String t) {
//		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < r && 0 <= nj && nj < c ) {//&& !visited[ni][nj]
				if (!t.contains(Character.toString(map[ni][nj]))) {
					dfs(ni, nj, t + Character.toString(map[ni][nj]));
				}
			}
		}
		if (t.length() > cnt) {
//			System.out.println(t);
			cnt = t.length();
		}
	}
}