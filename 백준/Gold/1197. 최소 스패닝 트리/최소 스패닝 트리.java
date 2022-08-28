import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v,e;
	static LinkedList<Edge> adjList[];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken()); e = Integer.parseInt(st.nextToken());
			adjList = new LinkedList[v+1];
			visited = new boolean[v+1];
			for(int i=1;i<=v;i++) {
				adjList[i] = new LinkedList<>();
			}
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
				adjList[from].add(new Edge(to, weight));
				adjList[to].add(new Edge(from, weight));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(1,0));
			long results = 0;
			int vertextcnt = 0;
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				if(visited[cur.num]) continue;
				results += cur.weights;
				visited[cur.num] = true;
				vertextcnt++;
				if(vertextcnt == v) break;
				for(Edge nextedge : adjList[cur.num]) {
					if(!visited[nextedge.num]) {
						pq.add(nextedge);
					}
				}
				
			}
			System.out.println(results);
	}
	static class Edge implements Comparable<Edge>{
		int num, weights;

		public Edge(int num, int weights) {
			this.num = num;
			this.weights = weights;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.weights>o.weights)
				return +1;
			else if(this.weights<o.weights)
				return -1;
			return 0;
		}
	}
}