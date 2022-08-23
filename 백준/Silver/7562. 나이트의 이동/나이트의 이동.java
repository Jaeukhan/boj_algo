import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int di[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int dj[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int cnt, n;
	static int map[][];
	static Cur end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		for (int tc = 0; tc < Tc; tc++) {
			cnt = 0;
			n = sc.nextInt();
			map = new int[n][n];
			Cur start = new Cur(sc.nextInt(), sc.nextInt());
			end = new Cur(sc.nextInt(), sc.nextInt());
			bfs(start);
			System.out.println(cnt);
		}
	}

	private static void bfs(Cur start) {
		Queue<Cur> que = new ArrayDeque<>();
		que.offer(start);
		map[start.i][start.j] = 1;
		if (start.i == end.i && start.j == end.j) {
			return;
		}
		cnt++;
		while (!que.isEmpty()) {
			int size = que.size();
			while (--size >= 0) {
				Cur cur = que.poll();
				for (int d = 0; d < 8; d++) {
					int nexti = cur.i + di[d];
					int nextj = cur.j + dj[d];
					if (nexti == end.i && nextj == end.j) {
						return;
					}
					if (nexti >= 0 && nexti < n && nextj >= 0 && nextj < n &&map[nexti][nextj]==0) {
						que.offer(new Cur(nexti, nextj));
						map[nexti][nextj] = 1;
					}
				}
			}
			cnt++;
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