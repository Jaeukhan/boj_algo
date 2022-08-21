import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n, ans;
	static int boxes[][];
	static int di[] = { 0, 1, 0, -1 };
	static int dj[] = { 1, 0, -1, 0 };
	static Queue<Cur> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		que = new ArrayDeque<>();
		boxes = new int[n][m];
		ans = 0;
		LinkedList<Cur> curs = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				boxes[i][j] = Integer.parseInt(st.nextToken());
				if (boxes[i][j] == 1) {
					que.offer(new Cur(i, j));
				}
			}
		}
		bfs(curs);
		if (check()) {
			System.out.println(ans - 1);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (boxes[i][j] == 0)
					return false;
				if (ans < boxes[i][j])
					ans = boxes[i][j];
			}
		}
		return true;
	}

	private static void bfs(LinkedList<Cur> curs) {
		while (!que.isEmpty()) {
			Cur current = que.poll();
			for (int d = 0; d < 4; d++) {
				int ni = current.i + di[d];
				int nj = current.j + dj[d];
				if (0 <= ni && ni < n && 0 <= nj && nj < m && boxes[ni][nj] == 0) {
					boxes[ni][nj] = boxes[current.i][current.j] + 1;
					que.offer(new Cur(ni, nj));
				}
			}
		}
	}

	static class Cur {
		int i, j;

		public Cur(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

}