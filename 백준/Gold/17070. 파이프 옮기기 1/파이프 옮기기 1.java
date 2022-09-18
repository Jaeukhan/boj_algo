import java.util.Scanner;

public class Main {
	static int[][] di = {{0,1},{1,1},{0,1,1}};
	static int[][] dj = {{1,1},{0,1},{1,1,0}};
	static int[][] direc = {{0,2},{1,2},{0,2,1}};
	static int[][] map;
	static int dir, cnt, n;
	static Point start;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for (int j = 1; j <=n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dir = 0;
		cnt = 0;
		start = new Point(1, 2);
		dfs(start, dir);
		System.out.println(cnt);
	}
	private static void dfs(Point s, int d) {
//		System.out.println(s.i+" "+s.j+" "+d); // 0:가로 1:세로 2: 대각선
		if(s.i==n&&s.j==n) {
			cnt++;
			return;
		}
		for(int i=0;i<di[d].length;i++) {
			int ni = s.i+di[d][i];
			int nj = s.j+dj[d][i];
//			System.out.println("갈수 있는 곳 "+ni+" "+nj);
			if(1<=ni&&ni<=n&&1<=nj&&nj<=n&&map[ni][nj]!=1) {
				if(i==1) {
					if(s.i+1<=n&&map[s.i+1][s.j]==0&&s.j+1<=n&&map[s.i][s.j+1]==0) {
						dfs(new Point(ni, nj), direc[d][i]);		
					}
				}else {
					dfs(new Point(ni, nj), direc[d][i]);					
				}
			}
		}
	}
	static class Point{
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}