import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, max;
	static LinkedList<Point> blocks;
	static LinkedList<Point> virus;
	static boolean[] select;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		max = 0;
		blocks = new LinkedList<>();
		virus = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0)
					blocks.add(new Point(i, j));
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		} // input end
		select = new boolean[blocks.size()];
		comb(0, 0);
		System.out.println(max);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == 3) {
			int[][] newmap = copy();

			for (int i = 0; i < blocks.size(); i++) {
				if (select[i]) {
					newmap[blocks.get(i).i][blocks.get(i).j] = 1;
				}
			}
//			print(newmap);
			bfs(newmap);
			return;
		}
		if(idx==blocks.size()) return;
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);

	}

	private static void print(int[][] newmap) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(newmap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] copy() {
		int[][] newMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}

	private static void bfs(int[][] newmap) {
		Queue<Point> que = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++) {
			que.add(virus.get(i));
		}
		while (!que.isEmpty()) {
			Point cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if (0 <= ni && ni < n && 0 <= nj && nj < m && newmap[ni][nj] == 0) {
					que.add(new Point(ni, nj));
					newmap[ni][nj] = 2;
				}
			}
		}
		cntarea(newmap);
	}

	private static void cntarea(int[][] newmap) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (newmap[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}