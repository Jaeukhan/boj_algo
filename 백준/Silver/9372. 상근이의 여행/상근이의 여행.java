import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static LinkedList<Integer> adjList[];
	static boolean visited[];
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			n = sc.nextInt(); m = sc.nextInt();
			adjList = new LinkedList[n+1];
			visited = new boolean[n+1];
			cnt = 0;
			for(int i=1;i<=n;i++) {
				adjList[i] = new LinkedList<>();
			}
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt(), b= sc.nextInt();
				adjList[a].add(b);
				adjList[b].add(a);
			}
			bfs();
			System.out.println(cnt-1);
		}

	}
	static void bfs() {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(1);
		visited[1] = true;
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {
				int cur = que.poll();
				for(int v :adjList[cur]) {
					if(!visited[v]) {
						que.add(v);
						visited[v] = true;
					}
				}
				cnt++;
			}
		}
	}
	
}