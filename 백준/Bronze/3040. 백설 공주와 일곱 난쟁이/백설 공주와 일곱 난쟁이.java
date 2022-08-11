import java.util.Scanner;

public class Main {
	static int[] nums = new int[9];
	static int[] results = new int[7];
	static boolean[] select = new boolean[9];
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			nums[i] = sc.nextInt();
		}
		comb(0,0);
		System.out.println(sb);
	}
	public static void comb(int idx, int cnt) {
		if(cnt==7) {
			int sum = 0;
			for(int i=0;i<9;i++) {
				if(select[i]) {
					sum += nums[i];
				}
			}
			if(sum==100) {
				for(int i=0;i<9;i++) {
					if(select[i]) {
						sb.append(nums[i]).append("\n");
					}
				}
			}
			return;
		}
		if(idx == 9) return;
		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
}