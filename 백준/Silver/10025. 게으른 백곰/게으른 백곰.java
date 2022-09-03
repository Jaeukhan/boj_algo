import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[] bucket = new int[1_000_001];//1_000_001
		int s = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			bucket[x] = g;
			if(x<s) {
				s=x;
			}
		}
		int ice = 0;
		for(int i=s;i<=s+2*k;i++) {
			if(i<bucket.length&&bucket[i]!=0) {
				ice += bucket[i];
			}
		}
		int max = ice;
		for (int start = s+1; start < bucket.length-2*k; start++) {
//			System.out.println(start);
			if(start-1>=0) {
				ice -= bucket[start-1];
			}
			if(start+2*k<bucket.length) {
				ice += bucket[start+2*k];
			}
			max = Math.max(max, ice);
		}

		System.out.println(max);
	}

}