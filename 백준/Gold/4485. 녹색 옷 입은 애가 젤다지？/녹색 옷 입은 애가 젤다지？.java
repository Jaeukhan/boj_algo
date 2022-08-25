import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int map[][];
	static int visit[][];
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			map = new int[n][n];
			visit = new int[n][n];
			for(int i=0;i<n;i++) {				
				Arrays.fill(visit[i], Integer.MAX_VALUE);
			}
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//input end
			visit[0][0] = map[0][0];
			move(new Point(0,0, visit[0][0]));
			System.out.println("Problem "+ tc++ +": "+visit[n-1][n-1]);
		}
	}
	private static void move(Point p) {
		Queue<Point> que = new ArrayDeque<>();
		que.add(p);
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int d=0;d<4;d++) {
				int ni = cur.i+di[d];
				int nj = cur.j+dj[d];
				if(0<=ni&&ni<n&&0<=nj&&nj<n) {
					if(visit[ni][nj]>visit[cur.i][cur.j]+map[ni][nj]) {
						visit[ni][nj] = visit[cur.i][cur.j]+map[ni][nj];
						que.add(new Point(ni, nj, visit[ni][nj]));
					}
				}
			}
		}
	}
	static class Point implements Comparable<Point>{
		int i, j, weight;

		public Point(int i, int j, int weight) {
			this.i = i;
			this.j = j;
			this.weight = weight;
		}
	

		@Override
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}}
}