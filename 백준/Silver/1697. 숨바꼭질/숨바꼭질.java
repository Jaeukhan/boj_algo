import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[], n ,k, limit;
 	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		limit = 100_001;
		map = new int[limit];
		n = sc.nextInt(); k = sc.nextInt();
		System.out.println(bfs(n));
	}
	private static int bfs(int s) {
		int ans = 0;
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(s);
		map[s] = 1;
		if(s==k) return ans;
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {
				int cur = que.poll();
				int next = cur*2;
				if(next==k) return ans+1;
				if(0<=next&&next<limit&&map[next]==0) {
					que.offer(next);
					map[next] = 1;
				}
				next = cur-1;
				if(next==k) return ans+1;
				if(0<=next&&next<limit&&map[next]==0) {
					que.offer(next);
					map[next] = 1;
				}
				next = cur+1;
				if(next==k) return ans+1;
				if(0<=next&&next<limit&&map[next]==0) {
					que.offer(next);
					map[next] = 1;
				}
			}
			ans++;
		}
		return 100_000;
	}
}