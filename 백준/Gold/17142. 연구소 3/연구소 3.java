import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, min, need, visit[][];
	static int[][] map;
	static LinkedList<Point> virus;
	static boolean select[], notexist;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		virus = new LinkedList<>();
		notexist = true;
		min = Integer.MAX_VALUE;
		need = 0;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				} else if (map[i][j] == 0)
					need++;
			}
		} // input end
		select = new boolean[virus.size()];
		comb(0, 0);
		if (notexist) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void comb(int idx, int cnt) {
		if (cnt == m) {
			sim();
			return;
		}
		if (idx == virus.size())
			return;
		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);
	}

	private static void sim() {
		visit = new int[n][n];
		int[][] copy = deepcopy(map);
		Queue<Point> que = new ArrayDeque<>();
		for (int i = 0; i < select.length; i++) {
			if (select[i]) {
				Point tmp = virus.get(i);
				que.add(tmp);
				visit[tmp.i][tmp.j] = 1;
			}
		}
		int cnt = 0;
		if (cnt == need) {
			notexist = false;
			min = 0;
			return;
		}
		while (!que.isEmpty()) {
				Point cur = que.poll();
				for (int d = 0; d < 4; d++) {
					int ni = cur.i + di[d];
					int nj = cur.j + dj[d];
					if (0 <= ni && ni < n && 0 <= nj && nj < n && copy[ni][nj] != 1 & visit[ni][nj] == 0) {
						visit[ni][nj] = visit[cur.i][cur.j] + 1;
						if (copy[ni][nj] == 0) {
							cnt++;
						} 
						que.add(new Point(ni, nj));
						if (cnt == need) {
							notexist = false;
							min = Math.min(min, visit[ni][nj]-1);
							return;
						}
					}

				}

//				System.out.println(visit[cur.i][cur.j]);
//			print(visit);
		}
	}


	private static void print(int[][] copy) {
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				System.out.print(copy[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static int[][] deepcopy(int[][] origin) {
		int[][] copy = new int[n][n];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}