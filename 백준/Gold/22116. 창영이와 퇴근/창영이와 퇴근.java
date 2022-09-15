import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
	static int n;
	static int[][] map, visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		visited = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited[1][1] = 0;
		bfs();
		System.out.println(visited[n][n]);
	}
	public static void bfs() {
		PriorityQueue<Point> que = new PriorityQueue<>();
		que.add(new Point(1,1, 0));
		while(!que.isEmpty()) {
			Point cur = que.poll();
			if(cur.slope>visited[cur.i][cur.j]) continue;
			for(int d=0;d<4;d++) {
				int ni = cur.i+di[d];
				int nj = cur.j+dj[d];
				if(1<=ni&&ni<=n&&1<=nj&&nj<=n) {
					if(visited[ni][nj]> Math.max(cur.slope, Math.abs(map[cur.i][cur.j]-map[ni][nj]))) {
						visited[ni][nj] = Math.max(cur.slope, Math.abs(map[cur.i][cur.j]-map[ni][nj]));
						que.add(new Point(ni, nj, visited[ni][nj]));
					}
				}
			}
		}
		
		
	}
	static class Point implements Comparable<Point>{
		int i, j, slope;

		public Point(int i, int j, int slope) {
			this.i = i;
			this.j = j;
			this.slope = slope;
		}
		@Override
		public int compareTo(Point o) {
			if (this.slope > o.slope) {
				return 1;
			}
			else if (this.slope < o.slope) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}