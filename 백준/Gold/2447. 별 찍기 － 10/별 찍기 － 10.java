import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb = new StringBuilder();
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] =' ';
			}
		}
		recur(n, 0, 0);
		print();
		System.out.println(sb);
	}

	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}

	public static void recur(int size, int i, int j) {
		if (size == 1) {
			map[i][j] = '*';
			return;
		}
		int newsize = size / 3;
		recur(newsize, i, j);
		recur(newsize, i, j + newsize);
		recur(newsize, i, j + newsize * 2);

		recur(newsize, i + newsize, j);
		recur(newsize, i + newsize, j + newsize * 2);

		recur(newsize, i + newsize * 2, j);
		recur(newsize, i + newsize * 2, j + newsize);
		recur(newsize, i + newsize * 2, j + newsize * 2);
	}
}