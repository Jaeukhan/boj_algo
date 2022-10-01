import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r,c,k;
	static char[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int ans;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		r  = Integer.parseInt(st.nextToken());
		c  = Integer.parseInt(st.nextToken());
		k  = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new boolean[r][c];
		ans = 0;
		for(int i=0;i<r;i++) {
			String line = br.readLine();
			for(int j=0;j<line.length();j++) {
				map[i][j] = line.charAt(j);
			}
		}//input end
		visit[r-1][0] = true;
		dfs(r-1,0, 1);
		System.out.println(ans);
	}
	private static void dfs(int i,int j, int cnt) {
//		System.out.println(i+" "+j);
		if(cnt==k) {
			if(i==0&&j==c-1) {
//				System.out.println("## "+ ans);
				ans++;
			}
			return;
		}

		for(int d=0;d<4;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni&&ni<r&&0<=nj&&nj<c&&!visit[ni][nj]&&map[ni][nj]!='T') {
				visit[ni][nj] = true;
				dfs(ni, nj, cnt+1);
				visit[ni][nj] = false;
			}
		}
	}
}