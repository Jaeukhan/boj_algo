import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int di[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int dj[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int w, h, ans;
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			ans = 0;
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 || h == 0)
				break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j]==1) {
						bfs(new Point(i, j));
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void bfs(Point point) {
		Queue<Point> que = new ArrayDeque<>();
		que.offer(point);
		map[point.i][point.j] = 0;
		while (!que.isEmpty()) {
			Point cur = que.poll();
			for (int d = 0; d < 8; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];
				if (0 <= nexti && nexti < h && 0 <= nextj && nextj < w && map[nexti][nextj] == 1) {
					que.offer(new Point(nexti, nextj));
					map[nexti][nextj] = 0;
				}
			}

		}
		ans++;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}