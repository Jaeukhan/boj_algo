import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, d, totalcnt;
	static int map[][];
	static boolean select[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Enemy> en = new ArrayList<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m];
		select = new boolean[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					en.add(new Enemy(i, j));
				}
			}
		}

		comb(0, 0, en);
		System.out.println(totalcnt);
	}

	static class Enemy {
		int x, y;

		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void comb(int idx, int cnt, ArrayList<Enemy> en) {
		if (cnt == 3) {
//			for (int i = 0; i < select.length; i++) {
//				System.out.print(select[i] + " ");
//			}
//			System.out.println();
			run(map, en);
			return;
		}
		if (idx == m)
			return;
		select[idx] = true;
		comb(idx + 1, cnt + 1, en);
		select[idx] = false;
		comb(idx + 1, cnt, en);
	}

	static void run(int[][] origin, ArrayList<Enemy> cl) {
		int[][] copy = deepcopy(origin);
		ArrayList<Enemy> en = (ArrayList<Enemy>) cl.clone();
		int cnt = 0;
//		System.out.println("---------------------------------------------------");
		while (!en.isEmpty()) {
			LinkedList<Enemy> loc = new LinkedList<>();
			for (int i = 0; i < select.length; i++) {
				int mindist = Integer.MAX_VALUE, x = 0, y = Integer.MAX_VALUE;
				if (select[i]) {
					for (int e = en.size()-1; e >=0 ;e--) {
						int dist = (Math.abs(n - en.get(e).x) + Math.abs(i - en.get(e).y));
						if (d >= dist) {//&& y>en.get(e).y
							if( dist < mindist ) {
								mindist = dist;
								x = en.get(e).x;
								y = en.get(e).y;
							}else if(dist==mindist&& y>en.get(e).y) {
								mindist = dist;
								x = en.get(e).x;
								y = en.get(e).y;
							}

					}
					}
				}

				if (check(loc, x, y)) {
					loc.add(new Enemy(x, y));
				}
			}
//			System.out.println("지울거");
//			print(loc);
			if (loc.size() != 0) {
				for (Enemy e : loc) {
					for (int j = 0; j < en.size(); j++) {
						if (en.get(j).x == e.x && en.get(j).y == e.y) {
							en.remove(j);
							cnt++;
							break;
						}
					}
				}
			}
			copy = movedown(copy, en);

//			System.out.println("cnt " + cnt);
		}
		totalcnt = Math.max(cnt, totalcnt);
	}

	static boolean check(LinkedList<Enemy> loc, int x, int y) {
		if (loc.isEmpty()) {
			if (x != 0)
				return true;
			else
				return false;
		} else {
			for (int i = 0; i < loc.size(); i++) {
				if ((x == 0) || (loc.get(i).x == x && loc.get(i).y == y)) {
					return false;
				}
			}
		}
		return true;
	}

	static int[][] deepcopy(int[][] origin) {
		int[][] copy = new int[n + 1][m];
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	static int[][] movedown(int[][] om, ArrayList<Enemy> en) {
		int[][] copy = new int[n + 1][m];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = om[i - 1][j];
			}
		}
		for (int e = en.size() - 1; e >= 0; e--) {
			int x = en.get(e).x + 1;
			int y = en.get(e).y;
			if ((int) x >= n) {
				en.remove(e);
			} else {
				en.remove(e);
				en.add(new Enemy(x, y));
			}
		}
		return copy;
	}

	static void print(List<Enemy> en) {
		for (int i = 0; i < en.size(); i++) {
			System.out.println(en.get(i).x + " " + en.get(i).y);
		}
		System.out.println();
	}
}