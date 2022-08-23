import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] origin, copy;
	static int N, M, D;
	static int ans;
	static boolean[] select; // 궁수 위치 뽑는 조합.

	static int[] di = { 0, -1, 0 }; // 왼, 위, 오 순서로 적을 탐색
	static int[] dj = { -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		origin = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				origin[i][j] = sc.nextInt();
			}
		} // end input
		select = new boolean[M];
		ans = 0;
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == 3) {
//			System.out.println(Arrays.toString(select));
			copy = deepcopy(origin); // 궁수배치해서 시뮬레이션 하기 전에 원본 복사!
			int score = 0;
			for (int turn = 0; turn < N; turn++) {
				score += attack(); // 궁수 턴
//				print(copy);
				move(); // 적들이 내려오는 턴.
//				print(copy);
			}
			ans = Math.max(ans, score);
			return;
		}
		if (idx == M)
			return;

		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);
	}

	private static void move() {
		for(int i=N-1; i-1>=0; i--) {
			for(int j=0; j<M; j++) {
				copy[i][j] = copy[i-1][j];
			}
		}
		for(int j=0; j<M; j++) { // 다 끌어 내렸으면 맨윗행 지워주기
			copy[0][j] =0;
		}
	}

	private static int attack() {
		// 3명의 궁수가 각각 타겟을 죽이지는 않고 겨냥만 하게 해야함.

		for (int j = 0; j < M; j++) { // 궁수 위치 찾아야함.
			if (select[j]) { // 궁수 여깄다! copy[N][j] 위치라고 생각하고 탐색 시작 !
				Queue<Point> queue = new LinkedList<>(); // 궁수좌표. 궁수 주변칸(빈칸, 적) 좌표들이 들어갈거임.
				PriorityQueue<Point> enemy = new PriorityQueue<>();

				boolean[][] visit = new boolean[N][M];
				queue.add(new Point(N, j)); // 사실 N번행은 없는 행이라.. 궁수 있는.. visit 시작점은 안할래..

				int dist = 0;
				while (!queue.isEmpty() && dist <= D) { // 현재 큐에 좌표가 있고 그 거리가 D이하일 때에만 진행
					int size = queue.size();
					for (int s = 0; s < size; s++) {
						Point now = queue.poll();

						if (copy[now.i][now.j] >= 1) { // 쏴죽일 대상이다!!(다른 궁수가 찜하면 ++돼있을 거라서;;)
							enemy.add(now);
						}

						for (int d = 0; d < 3; d++) {
							int nexti = now.i + di[d];
							int nextj = now.j + dj[d];
							if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visit[nexti][nextj]) {
								visit[nexti][nextj] = true;
								queue.add(new Point(nexti, nextj));
							}
						}
					}
					dist++;
					if (!enemy.isEmpty()) { // 방금전 그 거리에서 쏴죽일 적이 있었네?!
						Point target = enemy.poll(); // PQ라서 제일 왼쪽에 있는 애가 알아서 나옴.
						copy[target.i][target.j]++;
						break; // end bfs for archer now
					}
				} // end while
			} // end if archer
		} // end for M

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] > 1) {
					copy[i][j] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}// end bfs function

	static int[][] deepcopy(int[][] map) {
		int[][] tmp = new int[map.length+1][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	static class Point implements Comparable<Point> {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Point o) {
			return this.j - o.j;
		}
	}
}