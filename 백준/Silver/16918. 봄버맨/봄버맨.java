import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r, c, n;
	static char[][] map;
	static int[][] install;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		install = new int[r][c];
		for (int i = 0; i < r; i++) {
			String txt = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = txt.charAt(j);// O.
				if (map[i][j] == 'O') {
					install[i][j] = 1;
				}
			}
		} // input end
		int time = 1;
		while (time <= n) {
			if (time % 2 == 0) {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (map[i][j] == '.') {
							map[i][j] = 'O';
							install[i][j] = 0;
						}
					}
				}
			} else {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (install[i][j] == 3) {
							bomb(i,j);
						}
					}
				}
			}
			time++;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(map[i][j]=='O') {
						install[i][j]+=1;
					}
				}
			}
		}
		print();
		
	}

	private static void bomb(int i, int j) {
		map[i][j] = '.';
		install[i][j] = 0;
		for(int d=0;d<4;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0&&ni<r&&nj>=0&&nj<c&&install[ni][nj]!=3) {
				map[ni][nj] = '.';
				install[ni][nj] = 0;
			}
		}
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}