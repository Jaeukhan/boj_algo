import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] minutes = {300,60,10};
		int[] ans = new int[3];
		int T = sc.nextInt();
		for(int i=0;i<3;i++) {
			ans[i] = T/minutes[i];
			T%=minutes[i];
		}
		if(T!=0) {
			System.out.println(-1);
		}else {
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i]+" ");
			}
		}
	}
}