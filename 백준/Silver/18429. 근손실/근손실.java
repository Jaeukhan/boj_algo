import java.util.Scanner;

public class Main {
	static int n, k, cnt;
	static int[] weights, results;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n  =sc.nextInt(); k= sc.nextInt();
		cnt = 0;
		weights = new int[n];
		results = new int[n];
		for(int i=0;i<n;i++) {
			weights[i] = sc.nextInt();
		}
		perm(0, 0, 500);
		System.out.println(cnt);
	}
	private static void perm(int idx, int flag, int sum) {
		if(idx==n) {
//			for(int i =0;i<n;i++) {
//				System.out.print(results[i]);
//			}
//			System.out.println();
			cnt++;
			return;
		}
		for(int i=0;i<n;i++) {
			if((flag&1<<i)!=0||(sum+weights[i]-k<500)) continue;
			results[idx] = weights[i];
			perm(idx+1, flag|1<<i, sum+weights[i]-k);
			
		}
	}
}