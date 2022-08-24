import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, time;
	static char map[][];
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static Queue<Point> goque;
	static Queue<Point> flowque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		time = 0;
		map = new char[r][c];
		goque = new ArrayDeque<>();
		flowque = new ArrayDeque<>();
		for (int i = 0; i < r; i++) {
			String txt = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = txt.charAt(j);
				if (map[i][j] == 'S') {
					goque.add(new Point(i, j));
				} else if (map[i][j] == '*') {
					flowque.add(new Point(i, j));
				}
			}
		} // input end
		if (bfs()) {
			System.out.println(time);
		} else {
			System.out.println("KAKTUS");
		}

	}

	private static boolean bfs() {
		while (!goque.isEmpty()) {
			int size = flowque.size();
			while (--size >= 0) {// 물의 이동
				Point flowcur = flowque.poll();
				for (int d = 0; d < 4; d++) {
					int nigo = flowcur.i + di[d];
					int njgo = flowcur.j + dj[d];
					if (nigo >= 0 && nigo < r && njgo >= 0 && njgo < c
							&& (map[nigo][njgo] != '*'&&map[nigo][njgo] != 'X' && map[nigo][njgo] != 'D')) {
						flowque.add(new Point(nigo, njgo));
						map[nigo][njgo] = '*';
					}
				}
			}
			size = goque.size();
			while (--size >= 0) {// 고슴도치의 이동
				Point gocur = goque.poll();
				for (int d = 0; d < 4; d++) {
					int nigo = gocur.i + di[d];
					int njgo = gocur.j + dj[d];
					if (nigo >= 0 && nigo < r && njgo >= 0 && njgo < c
							&& (map[nigo][njgo] == '.' || map[nigo][njgo] == 'D')) {
						if (map[nigo][njgo] == 'D') {
							time++;
							return true;
						}
						goque.add(new Point(nigo, njgo));
						map[nigo][njgo] = 'S';
					}
				}
			}
			time++;
		}
		return false;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	private static void print() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}