import java.util.Scanner;

public class Main {
	static int[] results;
	static int[] cards;
	static boolean[] isSelected;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cards = new int[n];
		isSelected = new boolean[n];
		for (int i = 0; i < n; i++) {
			cards[i] = i+1;
		}
		m = sc.nextInt();
		results = new int[m];
		perm(0);
	}

	public static void perm(int idx) {
		if(idx ==results.length) {
			for(int i=0;i<results.length;i++) {
				System.out.print(results[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < cards.length; i++) {
			if(isSelected[i])
				continue;
			results[idx] = cards[i];
			isSelected[i] = true;
			perm(idx+1);
			isSelected[i] = false;
		}
	}
}