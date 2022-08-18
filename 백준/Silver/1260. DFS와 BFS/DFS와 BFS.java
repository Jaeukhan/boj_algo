import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n,m,v;
	static int[][] list;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		list = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from][to] = list[to][from] = 1;
		}

		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs();
	}
	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		for(int i=1;i<=n;i++) {
			if(!visited[i]&&list[v][i]!=0) {
				dfs(i);
			}
		}
		
	}
	private static void bfs() {
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(v);
		visited[v] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur+" ");
			for(int i=1;i<=n;i++) {
				if(list[cur][i]!=0&&!visited[i]) {
					que.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
}