import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Chick> list;
	static int n,m, min;
	static boolean[] select;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); //폐업시키지 않을 치킨집 최대 개수 m
		map = new int[n + 1][n + 1];
		min = Integer.MAX_VALUE;
		list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());//집, 치킨집 받아오기
				if (map[i][j] == 2)
					list.add(new Chick(i, j));//치킨집의 위치를 담아둔다.
			}
		}

		select = new boolean[list.size()];
		comb(0, 0);			
		System.out.println(min);
	}

	public static void comb(int idx, int cnt) {
		if (cnt == m) {
			for (int i = 0; i < select.length; i++) {
				if (!select[i]) {//선택되 지않으면 폐업 시킨다 0을 만듦.
					map[list.get(i).i][list.get(i).j] = 0;
				}
//				}else {//폐업 되지 않은 곳.
//					System.out.println("#m:"+m+" "+list.get(i).i + " " + list.get(i).j);
//				}
				
			}
			calcdist(); //치킨 거리 계산.
			for (int i = 0; i < select.length; i++) {
				if (!select[i]) {//폐업한 치킨집을 돌려놓고 다시 구함.
					map[list.get(i).i][list.get(i).j] = 2;
				}
			}
			return;
		}
		if (idx == select.length)
			return;
		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);
	}

	public static void calcdist() {
		int citydist = 0;//모든 치킨 거리의 합(도시의 치킨거리)
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int chickendist = Integer.MAX_VALUE;
				if (map[i][j] == 1) {//이 곳이 집이면
					for (int l = 0; l < list.size(); l++) {//치킨집을 전부불러와 집과의 치킨 거리를 계산하고 가장 작은값을 더해준다.
						if (map[list.get(l).i][list.get(l).j] == 2) {//치킨거리=집과 가장 가까운 치킨집 사이의 거리
							chickendist = Math.min(chickendist, Math.abs(i - list.get(l).i) + Math.abs(j - list.get(l).j));
						}
					}
					citydist += chickendist;
				}

			}
		}
		min = Math.min(citydist, min);//도시의 치킨거리가 가장 작은 값을 구한다
//		System.out.println(citydist);
	}

	public static class Chick {//치킨집의 좌표를 담아두는 객체.
		int i, j;

		public Chick() {
		}

		public Chick(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}