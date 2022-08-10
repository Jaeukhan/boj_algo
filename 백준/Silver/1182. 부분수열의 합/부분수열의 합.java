import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] select;
	static int n, s, gcnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt(); s = sc.nextInt();
		arr = new int[n];
		gcnt = 0;
		select = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			comb(0,0,i);			
		}
		System.out.println(gcnt);
	}
	public static void comb(int idx, int cnt, int m) {
		if(cnt==m) {
			int sum = 0;
			for(int i=0;i<select.length;i++) {
				if(select[i]) {
					sum += arr[i];
				}
			}
//			System.out.println(sum);
			if(sum==s)
				gcnt++;
			return;
		}
		if(idx ==n) return;
		select[idx] = true;
		comb(idx+1, cnt+1,m);
		select[idx] = false;
		comb(idx+1, cnt,m);
	}
}