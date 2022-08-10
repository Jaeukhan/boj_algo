import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[] results;
	static int[] select = { 1, 5, 10, 50 };
	static int n;
	static HashSet<Integer> arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new HashSet<>();
		n = sc.nextInt();
		results = new int[n];
		comb(0, 0);
		System.out.println(arr.size());
	}

	public static void comb(int cnt, int start) {
		if(cnt == n) {
			int sum = 0;
			for(int i=0;i<results.length;i++) {
				sum+=results[i];
			}
			arr.add(sum);
			return;
		}
		for(int i=start;i<select.length;i++) {
			results[cnt] = select[i];
			comb(cnt+1, i);
		}
	}
}