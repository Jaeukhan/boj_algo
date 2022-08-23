import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static char map[][];
	static int n, hcnt, ncnt;
	static int di[] = {0,1,0,-1};
	static int dj[] = {1,0,-1,0};	
	static boolean[][] hvisit, nvisit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String txt = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = txt.charAt(j);
			}
		}//input end
		hcnt = 0; ncnt = 0;
		nvisit =new boolean[n][n];
		hvisit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!hvisit[i][j]) {
					human(new Point(i, j, map[i][j]));					
				}
				if(!nvisit[i][j]) {
					nothuman(new Point(i, j, map[i][j]));					
				}
			}
		}
		System.out.println(hcnt+" "+ncnt);
	}
	private static void nothuman(Point p) {
		Queue<Point> que = new ArrayDeque<>();
		que.offer(p);
		nvisit[p.i][p.j] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				if(0<=nexti&&nexti<n&&0<=nextj&&nextj<n&&!nvisit[nexti][nextj]) {
					char a =(cur.color=='R'||cur.color=='G')? 'R':'B';
					char b =(map[nexti][nextj]=='R'||map[nexti][nextj]=='G')? 'R':'B';
					if(a==b) {
						que.offer(new Point(nexti, nextj, cur.color));
						nvisit[nexti][nextj] = true;
					}

				}
			}
			
		}
		ncnt++;
	}
	private static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(nvisit[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void human(Point p) {
		Queue<Point> que = new ArrayDeque<>();
		que.offer(p);
		hvisit[p.i][p.j] = true;
		while(!que.isEmpty()) {
			Point cur = que.poll();
			for(int d=0;d<4;d++) {
				int nexti = cur.i+di[d];
				int nextj = cur.j+dj[d];
				if(0<=nexti&&nexti<n&&0<=nextj&&nextj<n&&map[nexti][nextj]==cur.color&&!hvisit[nexti][nextj]) {
					que.offer(new Point(nexti, nextj, cur.color));
					hvisit[nexti][nextj] = true;
				}
			}
		}
		hcnt++;
	}
	static class Point{
		int i,j;
		char color;

		public Point(int i, int j,char color) {
			this.i = i; this.j = j;
			this.color = color;
		}
		
	}
}