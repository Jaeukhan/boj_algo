import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v, e, start;
	static LinkedList<Edge> adjList[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		adjList = new LinkedList[v + 1];
		for (int i = 1; i <= v; i++) {
			adjList[i] = new LinkedList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to, weight));
		}
		int[] D = new int[v + 1];
		boolean[] visited = new boolean[v + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;
		PriorityQueue<Edge> que = new PriorityQueue<>();
		que.add(new Edge(start, 0));
		while (!que.isEmpty()) {
			Edge cur = que.poll();
			if (visited[cur.num])
				continue;
			visited[cur.num] = true;
			for (Edge edge : adjList[cur.num]) {
				if (!visited[edge.num] && D[edge.num] > D[cur.num] + edge.weight) {
					D[edge.num] = D[cur.num] + edge.weight;
					que.add(new Edge(edge.num, D[edge.num]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if(D[i]==Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}else {
				sb.append(D[i]).append("\n");
			}
		}
		System.out.println(sb);
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