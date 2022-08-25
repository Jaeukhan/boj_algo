import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static LinkedList<Edge> adjList[];
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adjList = new LinkedList[n+1];
		for(int i=1;i<=n;i++) {
			adjList[i] = new LinkedList<>();
		}
		visited = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()),
					weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, weight));
			adjList[to].add(new Edge(from, weight));
		}//input end
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		long result = 0, cnt = 0;
		while(!pq.isEmpty()) {
			Edge minedge = pq.poll();
			if(visited[minedge.num]) continue;
			result += minedge.weight;
			visited[minedge.num] = true;
			if(cnt++==n) break;
			for(Edge edge: adjList[minedge.num]) {
				if(!visited[edge.num]) {
					pq.add(edge);
				}
			}
		}
		System.out.println(result);
	}

	static class Edge implements Comparable<Edge> {
		int num, weight;

		public Edge(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}
}