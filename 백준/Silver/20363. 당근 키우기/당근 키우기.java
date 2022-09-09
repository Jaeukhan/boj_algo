import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt();
		int tmp = 0;
		if(y>x) {
			tmp = y;
			y = x;
			x = tmp;
		}
		int ans = x;
		ans += y/10+y;
		System.out.println(ans);
	}
}