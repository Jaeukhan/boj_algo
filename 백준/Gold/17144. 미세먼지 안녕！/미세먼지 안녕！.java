import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] di = {0,1, 0,-1};
	static int[] dj = {1,0,-1,0};
	static int r, c, t;
	static int top=0, bottom=1;
	static int[][] map, change;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		boolean lineselect=false;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1&&!lineselect) {
					lineselect = true;
					top = i;
					bottom = i+1;
				}
			}
		}//input end
		for(int i=0;i<t;i++) {
			spread();
			active();
		}
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]>0) sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	private static void active() {
		topturn();
		botturn();
	}
	private static void botturn() {
		int dir = 1;
		int i = bottom+1, j = 0;
		while(true) {
			int ni = i+di[dir];
			int nj = j+dj[dir];
			if(ni==bottom&&nj==0) {
				map[i][j] = 0;
				break;
			}
			if(bottom<=ni&&ni<r&&0<=nj&&nj<c) {
				map[i][j] = map[ni][nj];
			}else {
				 dir = (dir-1<0)?(dir+3):dir-1;
				 ni = i+di[dir];
				 nj = j+dj[dir];
				 map[i][j] = map[ni][nj];
			}
			i = ni;
			j = nj;
		}
	}
	private static void topturn() {
		int dir = 3;
		int i = top-1, j = 0;
		while(true) {

			int ni = i+di[dir];
			int nj = j+dj[dir];
			if(ni==top&&nj==0) {
				map[i][j] = 0;
				break;
			}
			if(0<=ni&&ni<=top&&0<=nj&&nj<c) {
				map[i][j] = map[ni][nj];
			}else {
				 dir = (dir+1)%4;
				 ni = i+di[dir];
				 nj = j+dj[dir];
				 map[i][j] = map[ni][nj];
			}
			i = ni;
			j = nj;
		}
	}
	static int[][] deepcopy(int[][] origin){
		int[][] copy = new int[origin.length][origin[0].length];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[0].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}
	private static void spread() {
		change = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j]>0) {
					bfs(new Point(i,j));
				}
			}
		}
		map = deepcopy(change);
		map[top][0] = -1;
		map[bottom][0] = -1;
	}
	private static void bfs(Point p) {
		int cnt = 0;
		for(int d=0;d<4;d++) {
			int ni = p.i+di[d];
			int nj = p.j+dj[d];
			if(0<=ni&&ni<r&&0<=nj&&nj<c&&map[ni][nj]!=-1) {
				change[ni][nj] += map[p.i][p.j]/5;
				cnt++;
			}
		}
		change[p.i][p.j] += (map[p.i][p.j] - (map[p.i][p.j]/5)* cnt);
	}
	static class Point{
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}