import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] results;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		results = new int[m];
		comb(0, 1);
		System.out.println(sb);
	}
	public static void comb(int cnt, int start) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(results[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=n;i++) {
			results[cnt] = i;
			comb(cnt+1,i);
		}
	}
}