import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n, min;
	static int[] person, results;
	static boolean[] select;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		min = 2000;
		person = new int[n+1];
		map = new int[n+1][n+1];
		select = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			person[i] = i;
			StringTokenizer st  =new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(1, 0);
		System.out.println(min);
	}
	public static void comb(int idx, int cnt) {
		LinkedList<Integer> team1 = new LinkedList<>();
		LinkedList<Integer> team2 = new LinkedList<>();
		if(cnt==n/2) {
			for(int i=1;i<select.length;i++) {
				if(select[i]) {
					team1.add(person[i]);
				}else {
					team2.add(person[i]);					
				}
			}
			Calc(team1, team2);
			return;
		}
		if(idx==n) return;
		select[idx] = true;
		comb(idx+1,cnt+1);
		select[idx] = false;
		comb(idx+1,cnt);
		
	}
	public static void Calc(LinkedList<Integer> team1, LinkedList<Integer> team2) {
		int s1=0, s2=0;
		for(int i=0;i<team1.size()-1;i++) {
			for(int j=i+1;j<team1.size();j++) {
				s1+=map[team1.get(i)][team1.get(j)];
				s1+=map[team1.get(j)][team1.get(i)];
				s2+=map[team2.get(i)][team2.get(j)];
				s2+=map[team2.get(j)][team2.get(i)];
			}
		}
		min = Math.min(min, Math.abs(s1-s2));
	}
}