import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer> adjlist[];
	static boolean visited[];
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		adjlist = new LinkedList[n];
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			adjlist[i] = new LinkedList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from  =Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			adjlist[from].add(to);
			adjlist[to].add(from);
		}//input end
		if(check()) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	private static boolean check() {
		for(int i=0;i<n;i++) {
			visited[i] = true;
			if(search(adjlist[i],0)) {
				return true;
			}
			visited[i] = false;
		}
		return false;
	}
	private static boolean search(LinkedList<Integer> link, int cnt) {
		if(cnt==4) return true;
		for(int go:link) {
			if(!visited[go]) {
				visited[go]=true;;
				if(search(adjlist[go], cnt+1))
					return true;
				visited[go]=false;;
			}
		}
		return false;
	}
}