import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static char map[][];
	static boolean visited[][];
	static LinkedList<Integer> homes;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][];
		homes = new LinkedList<>();
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]=='1'&&!visited[i][j]) {
					int cnt = dfs(i,j,1);
					if(cnt !=0 ) {
						homes.add(cnt);
					}
					
				}
			}
		}
		Collections.sort(homes);
		System.out.println(homes.size());
		for (int i = 0; i < homes.size(); i++) {
			System.out.println(homes.get(i));
		}
		
	}

	private static int dfs(int i, int j, int cnt) {
		visited[i][j] = true;
		for(int d=0;d<di.length;d++) {
			int ni = i+di[d];
			int nj= j+dj[d];
			if(0<=ni&&ni<n&&0<=nj&&nj<n&&!visited[ni][nj]&&map[ni][nj]=='1') {
				cnt = dfs(ni, nj, cnt+1);
			}
		}
		return cnt;
	}
}