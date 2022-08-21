import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<CCTV> cam;
	static int totalzero;
	static int[] di = { -1, 0, 1, 0 }; 
	static int[] dj = { 0, -1, 0, 1 };
	
	static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		totalzero = Integer.MAX_VALUE;
		cam = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cam.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		perm(0,map);
		System.out.println(totalzero);

	}
	private static void perm(int idx, int[][] origin) {
		if(idx == cam.size()) {
			int zero = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					zero += origin[i][j]==0?1:0;
				}
			}
			totalzero = Math.min(totalzero, zero);
			return;
		}
		CCTV now = cam.get(idx);
		int[][] copy;
		switch (now.num) {
		case 1:
			copy = deepcopy(origin);
			draw(now, UP, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, DOWN, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, LEFT, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, RIGHT, copy);
			perm(idx+1, copy);
			break;

		case 2:
			copy = deepcopy(origin);
			draw(now, UP, copy);
			draw(now, DOWN, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, LEFT, copy);
			draw(now, RIGHT, copy);
			perm(idx+1, copy);
			
			break;
		case 3:
			copy = deepcopy(origin);
			draw(now, UP, copy);
			draw(now, RIGHT, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, DOWN, copy);
			draw(now, RIGHT, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, DOWN, copy);
			draw(now, LEFT, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, LEFT, copy);
			draw(now, UP, copy);
			perm(idx+1, copy);
			break;
		case 4:
			copy = deepcopy(origin);
			draw(now, UP, copy);
			draw(now, RIGHT, copy);
			draw(now, LEFT, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, UP, copy);
			draw(now, RIGHT, copy);
			draw(now, DOWN, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, DOWN, copy);
			draw(now, RIGHT, copy);
			draw(now, LEFT, copy);
			perm(idx+1, copy);
			
			copy = deepcopy(origin);
			draw(now, LEFT, copy);
			draw(now, UP, copy);
			draw(now, DOWN, copy);
			perm(idx+1, copy);
			break;
		case 5:
			copy = deepcopy(origin);
			draw(now, UP, copy);
			draw(now, DOWN, copy);
			draw(now, LEFT, copy);
			draw(now, RIGHT, copy);
			perm(idx+1, copy);
			break;

		default:
			break;
		}

	}
	
	private static void draw(CCTV now, int dir, int[][] map) {
		int ni = now.i + di[dir];
		int nj = now.j + dj[dir];
		while (true) {
			if (ni<0 || ni>=N || nj<0 || nj>=M || map[ni][nj] == 6)
				break;
			map[ni][nj] = 9;
			ni += di[dir];
			nj += dj[dir];
		}

	}
	static int[][] deepcopy(int[][] origin) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				copy[i][j] = origin[i][j];
		}
		return copy;
	}

	static class CCTV {
		int i, j;
		int num;

		CCTV(int i, int j, int num) {
			this.i = i;
			this.j = j;
			this.num = num;
		}
	}

}