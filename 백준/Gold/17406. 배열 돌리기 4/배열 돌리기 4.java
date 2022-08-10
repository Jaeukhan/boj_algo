import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int min = 5000, n, m, k;
	static int[][] map, tmpmap;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static LinkedList<Rotc> rot;
	static boolean[] select;
	static Rotc[] selectrot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		select = new boolean[k];
		selectrot = new Rotc[k];
		map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rot = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			rot.add(new Rotc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		perm(0);
		System.out.println(min);
	}

	public static void perm(int idx) {

		if (idx == k) {
			tmpmap = new int[n+1][m+1];
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					tmpmap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < k; i++) {
				tmpmap = rotexe(selectrot[i]);
			}
			minsearch(tmpmap);
			return;
		}
		for (int i = 0; i < k; i++) {
			if (select[i])
				continue;
			selectrot[idx] = rot.get(i);
			select[i] = true;
			perm(idx + 1);
			select[i] = false;
		}
	}

	public static class Rotc {
		int r, c, s;

		public Rotc() {
		}

		public Rotc(int r, int c) {
			this.r = r;
			this.c = c;
			this.s = 0;
		}

		public Rotc(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static int[][] rotexe(Rotc ro) {//3,4,2같은 좌표로 회전
		
		int si = ro.r - ro.s - 1, sj = ro.c - ro.s - 1, ei = ro.r + ro.s + 1, ej = ro.c + ro.s + 1;
		int tmp[][] = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				tmp[i][j] = tmpmap[i][j];
			}
		}
		while (true) {
			si += 1;
			sj += 1;
			ei -= 1;
			ej -= 1;

			int nowr = si, nowc = sj;
			int init = tmpmap[nowr+1][nowc], dir = 0;
			if (si == ro.r || sj == ro.c)
				break;

			while (true) {
				int nextr = nowr + di[dir], nextc = nowc + dj[dir];
				if(nextr==si&&nextc==sj) {
					tmp[nextr][nextc] = init;
					break;
				}
				if (si <= nextr && nextr <= ei && sj <= nextc && nextc <= ej) {
					tmp[nextr][nextc] = tmpmap[nowr][nowc];
				} else {
					dir += 1;
					if (dir == 4) {
						dir = 0;
						break;
					}
						
					nextr = nowr + di[dir];
					nextc = nowc + dj[dir];
					tmp[nextr][nextc] = tmpmap[nowr][nowc];
				}
				nowr = nextr;
				nowc = nextc;
			}

		}
//		print(tmp);
		return tmp;
	}

	public static void minsearch(int[][] arr) {// 행에서 가장 작은값 도출.
		for (int i = 1; i < arr.length; i++) {
			int sum = 0;
			for (int j = 1; j < arr[0].length; j++) {
				sum += arr[i][j];
			}
			min = Math.min(min, sum);
		}
	}
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}