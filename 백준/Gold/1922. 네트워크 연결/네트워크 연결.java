import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static LinkedList<Edge> adjList;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		adjList = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()),
					weight = Integer.parseInt(st.nextToken());
			adjList.add(new Edge(from, to, weight));
		}
		Collections.sort(adjList);
		make();
		long result = 0, cnt = 0;
		for(Edge edge: adjList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt==n-1) break;
			}
		}
		System.out.println(result);
	}
	static void make() {
		for(int i=1;i<=n;i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}
}