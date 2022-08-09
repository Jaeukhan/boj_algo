import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
				r = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] visited;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dir = 0;
		for (int i = 0; i < r; i++) {
			int sxi = -1, syj = -1;
			visited = new boolean[n][m];
			while (cnt < (n * m)) {
				sxi += 1;
				syj += 1;
				int si = sxi, sj = syj;
				int init = map[si][sj];
//				System.out.println(sxi+" "+syj+" s: "+init);
//				System.out.println("#"+i+Arrays.deepToString(map));
				while (true) {
					int ni = si + di[dir], nj = sj + dj[dir];
					if (0 <= ni && ni <= n - 1 && 0 <= nj && nj <= m - 1 &&!visited[ni][nj]) {
						map[si][sj] = map[ni][nj];
						visited[ni][nj] = true;
						si = ni;
						sj = nj;
						cnt++;
					} else {
						dir += 1;
						if (dir == 4) {
							dir = 0;
							map[sxi + 1][syj] = init;
							break;
						}
						ni = si + di[dir];
						nj = sj + dj[dir];
						map[si][sj] = map[ni][nj];
						visited[ni][nj] = true;
						si = ni;
						sj = nj;
						cnt++;
					}
//					System.out.println("ni " + si + " nj " + sj + " dir: " + dir + " cnt " + cnt);
				}
			}
			cnt = 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}