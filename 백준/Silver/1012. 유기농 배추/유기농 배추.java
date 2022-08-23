import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int m,n, cnt;
	static int map[][];
	static int di[] = {0,1,0,-1};
	static int dj[] = {1,0,-1,0};
 	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int Tc = sc.nextInt();
		for(int tc=0;tc<Tc;tc++) {
			m  =sc.nextInt(); n = sc.nextInt();
			int k = sc.nextInt();
			map = new int[n][m];
			cnt = 0;
			for(int i=0;i<k;i++) {
				int x = sc.nextInt(), y = sc.nextInt();
				map[y][x] = 1;
			}
			for(int i=0;i<n;i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]==1) {
						bfs(new Cur(i,j));
					}
				}
			}
			System.out.println(cnt);
		}
	}
	private static void bfs(Cur c) {
		Queue<Cur> que = new ArrayDeque<>();
		que.offer(c);
		map[c.i][c.j] = 0;
		while(!que.isEmpty()) {
			Cur cur = que.poll();
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				if(0<=nexti&&nexti<n&&0<=nextj&&nextj<m&&map[nexti][nextj]==1) {
					que.offer(new Cur(nexti, nextj));
					map[nexti][nextj] = 0;
				}
			}
		}
		cnt++;
//		print();
	}
	private static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static class Cur{
		int i, j;
		public Cur(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}