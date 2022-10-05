import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int h, w;
	static int[][] map;
	static int time, cheese, hremain;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		map = new int[h + 2][w + 2];
		time = 0;
		cheese=0;
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) cheese++;
			}
		} // input end
		hremain = cheese;
		while (true) {
			spread();
			if(cheese==0) break;
			hremain= cheese;
			melt();
		}
		System.out.println(time);
		System.out.println(hremain);
	}

	private static void melt() {
		for (int i = 1; i < h + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (map[i][j] == 3)
					map[i][j] = 0;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < h + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void spread() {
		visited = new boolean[h + 2][w + 2];
		Queue<Point> que = new ArrayDeque<>();
		que.add(new Point(0, 0));
		visited[0][0] = true;
		while (!que.isEmpty()) {
			Point cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int ni = cur.i + di[d];
				int nj = cur.j + dj[d];
				if (0 <= ni && ni < h + 2 && 0 <= nj && nj < w + 2 && !visited[ni][nj] && map[ni][nj] != 3) {
					if (map[ni][nj] == 1) {
						map[ni][nj] = 3;
						cheese--;
					} else {
						que.add(new Point(ni, nj));
						visited[ni][nj] = true;
					}
				}
			}
		}
		time++;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}