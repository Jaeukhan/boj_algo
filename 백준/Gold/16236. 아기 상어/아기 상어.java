import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, fishes, ans;
	static int map[][];
	static boolean visited[][];
	static Queue<Cur> que;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	public static void main(String[] args) {
//		float st = System.nanoTime();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		fishes = 0;ans = 0;
		Cur start = new Cur(0,0,2,2);;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					start = new Cur(i,j,2,2);
					map[i][j] = 0;
				}else if(0<map[i][j]&&map[i][j]<=6) {
					fishes++;
				}
			}
		}//input end
		if(fishes==0) {
			System.out.println(0);
		}else {
			bfs(start);
			System.out.println(ans);
		}
//			float en = System.nanoTime();
//		System.out.println((en-st)+" s");
		
	}
	private static void bfs(Cur start) {
		que = new ArrayDeque<>();
		que.add(start);
		visited = new boolean[n][n];
		visited[start.i][start.j] = true;
		PriorityQueue<Cur> eating = new PriorityQueue<>();
		int time = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {
				Cur cur = que.poll();
				if(map[cur.i][cur.j]!=0&&map[cur.i][cur.j]<cur.size) {
					eating.add(new Cur(cur.i, cur.j, time, time));
				}
				for(int d=0;d<4;d++) {
					int ni = cur.i+di[d];
					int nj = cur.j+dj[d];
					if(0<=ni&&ni<n&&0<=nj&&nj<n&&map[ni][nj]<=cur.size&&!visited[ni][nj]) {
						que.add(new Cur(ni,nj, cur.size,cur.need));
						visited[ni][nj] = true;
					}
				}
			}
			time++;
		}
//		print();
		if(eating.size()==0) return;
		Cur small = eating.poll();
		ans+= small.need;
		if(--fishes==0) return;
		int i=small.i,j=small.j,size = start.size,need = start.need-1;
		map[i][j] = 0;
//		System.out.println("현재까지 시간 "+ans+" 추가되는 시간 "+time+" 현재크기 "+size+" 필요한 물고기 "+need );
		if(need==0) {
			bfs(new Cur(i,j,size+1,size+1));						
		}else {
			bfs(new Cur(i,j,size,need));			
		}
	}
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static class Cur implements Comparable<Cur>{
		int i, j, size=0, need=0;
		public Cur(int i, int j) {
			this.i = i;
			this.j = j;
		}
		public Cur(int i, int j, int size,int need) {
			super();
			this.i = i;
			this.j = j;
			this.size = size;
			this.need = need;
		}
		@Override
		public int compareTo(Cur o) {
			if(this.size>o.size)
				return +1;
			else if(this.size==o.size) {
				if(this.i>o.i) 
					return +1;
				else if(this.i==o.i) {
					if(this.j>o.j)
						return +1;
					else
						return-1;
				}else {
					return -1;
				}
			}
			
			return -1;
		}
		
	}
}