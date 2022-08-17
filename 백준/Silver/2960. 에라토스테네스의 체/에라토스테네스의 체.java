import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		LinkedList<Integer> arr = new LinkedList<>();
		for (int i = 2; i <= n; i++) {
			arr.add(i);
		}
		run(arr, k);

	}
	public static void run(LinkedList<Integer> arr, int k) {
		int idx = 0;
		while (true) {
			int p = arr.get(0);
			arr.remove(0);
			idx++;
			if (idx == k) {
				System.out.println(p);
				return;
			}
			for(int i=0;i<arr.size();i++) {
	//				System.out.println(arr.get(i)+" "+idx);
	//				System.out.println(Arrays.toString(arr.toArray()));
				int a = arr.get(i);
				if(a%p==0) {
					idx++;
					arr.remove(i);
					i--;
				}
				if (idx == k) {
					System.out.println(a);
					return;
				}
			}
		}
	}
}