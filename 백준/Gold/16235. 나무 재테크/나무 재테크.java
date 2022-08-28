import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static int[][] A, map;
	static Queue<Tree> dead, Trees;
	static int[] di = { -1, -1, -1, 0, 0, +1, +1, +1 };
	static int[] dj = { -1, 0, 1, -1, +1, -1, 0, +1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		A = new int[n][n];
		Trees = new LinkedList<>();
		dead = new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 5);
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			Trees.add(new Tree(x, y, z));
		} // input end
		Collections.sort((List<Tree>) Trees);
		for (int i = 0; i < k; i++) {
			spring();
			summer();
			fall();
			winter();
			Collections.sort((List<Tree>) Trees);
		}
		System.out.println(Trees.size());
	}

	private static void spring() {
		int size = Trees.size();
		for (int i = 0; i < size; i++) {
			Tree tree = Trees.poll();
			if (map[tree.i][tree.j] - tree.feed < 0) {
				dead.add(tree);
			} else {
				map[tree.i][tree.j] -= tree.feed;
				Trees.add(new Tree(tree.i, tree.j, tree.feed + 1));
			}
		}
	}

	private static void summer() {
		while (!dead.isEmpty()) {
			Tree tree = dead.poll();
			map[tree.i][tree.j] += (tree.feed / 2);
		}
	}

	private static void fall() {
		int size = Trees.size();
		for (int i = 0; i < size; i++) {
			Tree tree = Trees.poll();
			if (tree.feed%5 == 0) {
				for (int z = 0; z < 8; z++) {
					int ni = tree.i + di[z];
					int nj = tree.j + dj[z];
					if(0<=ni&&ni<n&&0<=nj&&nj<n) {
						Trees.add(new Tree(ni, nj, 1));						
					}
				}
			}
			Trees.add(tree);
		}
	}

	private static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

	static class Tree implements Comparable<Tree> {
		int i, j, feed;

		public Tree(int i, int j, int feed) {
			this.i = i;
			this.j = j;
			this.feed = feed;
		}

		@Override
		public int compareTo(Tree o) {
			return this.feed - o.feed;
		}
	}
}