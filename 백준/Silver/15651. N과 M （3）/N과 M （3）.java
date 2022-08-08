import java.util.Scanner;

public class Main {
	static int[] cards;
	static int[] results;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int n =sc.nextInt(), m = sc.nextInt();
		cards = new int[n];
		results = new int[m];
		
		for(int i =0;i<n;i++) {
			cards[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	}
	public static void perm(int idx) {
		if(idx == results.length) {
			for(int i =0;i< results.length;i++) {
				sb.append(results[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<cards.length;i++) {
			results[idx] = cards[i];
			perm(idx+1);
		}
	}
}