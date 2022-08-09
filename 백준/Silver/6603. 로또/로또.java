import java.util.Scanner;

public class Main {
	static int[] arr;
	static int n;
	static boolean[] select;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			arr = new int[n];
			select = new boolean[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			comb(0,0);
			System.out.println();
		}
	}
	public static void comb(int idx, int cnt) {
		if(cnt==6) {
			for(int i=0;i<select.length;i++) {
				if(select[i])
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx==arr.length)
			return;
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
}