import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    static int[] dp;
	static int[] hum;
	static int max;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		hum = new int[n+1];
		dp = new int[n+1];
		max = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			hum[i] = sc.nextInt();
		}
		for(int i=1;i<=n;i++){
		    dp[i] = 1;
		    for(int j=1;j<i;j++) {
                if(hum[j]>hum[i]&&dp[i]<dp[j]+1){//
                    dp[i] = dp[j]+1;
                }		    
		    }
		}
		int max = - 1;
		for(int i=1;i<=n;i++){
		    max = dp[i] > max? dp[i]:max;
		}
		System.out.println(n-max);
	}
}