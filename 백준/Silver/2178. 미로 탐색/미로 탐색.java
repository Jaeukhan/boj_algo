import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] map;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		visited = new boolean[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			char[] txt = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j + 1] = txt[j] - '0';
			}
		}
		Cur start = new Cur(1, 1);
		bfs(start);
		System.out.println(map[n][m]);
	}
	public static void bfs(Cur start) {
		Queue<Cur> q = new LinkedList<>();
		q.offer(start);
		visited[start.i][start.j] = true;
		while(!q.isEmpty()) {
			Cur s = q.poll();
			if(s.i==n&&s.j==m) {
				break;
			}
			for(int k=0;k<4;k++) {
				int ni = s.i+di[k];
				int nj = s.j+dj[k];
				if(0<=ni&&ni<=n && 0<=nj&&nj<=m) {
					if(!visited[ni][nj]&&map[ni][nj]==1) {
						visited[ni][nj] = true;
						map[ni][nj] = map[s.i][s.j]+1;
						q.offer(new Cur(ni, nj));
					}
				}
			}
		}
	}
	public static class Cur{
		int i, j;
		public Cur(int i, int j) {
			this.i = i; this.j=j;
		}
	}
}