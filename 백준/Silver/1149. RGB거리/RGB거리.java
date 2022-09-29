import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int[][] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n][3];
		dist = new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				dist[i][j] = sc.nextInt();
				if(i==0) {
					dp[0][j] = dist[i][j];
				}
			}
		}//input end
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				dp[i][j] += dist[i][j];
				if(j==0) {
					dp[i][j] += Math.min(dp[i-1][1], dp[i-1][2]);					
				}else if(j==1) {
					dp[i][j] += Math.min(dp[i-1][0], dp[i-1][2]);
				}else {
					dp[i][j] += Math.min(dp[i-1][1], dp[i-1][0]);
				}
			}
		}
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}
}