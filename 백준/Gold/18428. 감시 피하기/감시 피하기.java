import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static String[][] map;
	static LinkedList<Point> blocks;
	static LinkedList<Point> teach;
	static boolean[] select;
	static boolean isYes = false;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new String[n][n];
		blocks = new LinkedList<>();
		teach = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken();
				if (map[i][j].equals("X")) {
					blocks.add(new Point(i, j));
				} else if (map[i][j].equals("T")) {
					teach.add(new Point(i, j));
				}
			}
		}
		select = new boolean[blocks.size()];
		comb(0, 0);
		System.out.println(isYes ? "YES" : "NO");

	}

	private static void comb(int idx, int cnt) {
		if (cnt == 3) {
//			System.out.println("comb");
			if (isYes)
				return;
			String[][] m = deepcopy(map);
			for (int i = 0; i < select.length; i++) {
				if (select[i]) {
					Point cur = blocks.get(i);
					m[cur.i][cur.j] = "B";
				}
			}
			for (int i = 0; i < teach.size(); i++) {
				visited = new boolean[n][n];
				for (int d = 0; d < 4; d++) {
					if (dfs(new Point(teach.get(i).i, teach.get(i).j), m, d)) {
						return;
					}
				}
			}
			isYes = true;
			return;
		}
		if (idx == blocks.size())
			return;
		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);
	}

	static boolean dfs(Point point, String[][] m, int d) {
		visited[point.i][point.j] = true;
		int ni = point.i + di[d];
		int nj = point.j + dj[d];
		if (0 <= ni && ni < n && 0 <= nj && nj < n && !visited[ni][nj]) {
			if (m[ni][nj].equals("X")) {
				if(dfs(new Point(ni, nj), m, d)) return true;
			} else if (m[ni][nj].equals("S")) {
				return true;
			}
		}
		return false;
	}
//	private static boolean bfs(Point point, String[][] m) {
//		visited = new boolean[n][n];
//		Queue<Point> que = new ArrayDeque<>();
//		que.add(point);
//		visited[point.i][point.j] = true;
//		while(!que.isEmpty()) {
//			Point cur = que.poll();
//			System.out.println(cur.i+" "+cur.j);
//			for(int d=0;d<4;d++) {
//				int ni = cur.i+di[d];
//				int nj = cur.j+dj[d];
//				if(0<=ni&&ni<n&&0<=nj&&nj<n&&!visited[ni][nj]) {
//					if(m[ni][nj].equals("X")) {
//						que.add(new Point(ni, nj));
//						visited[ni][nj] = true;
//					}else if(m[ni][nj].equals("S")) {
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}

	static String[][] deepcopy(String[][] m) {
		String[][] tmp = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp[i][j] = m[i][j];
			}
		}
		return tmp;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}