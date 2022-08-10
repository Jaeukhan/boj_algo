import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 1;
		int x = sc.nextInt();
		int odd = 1;
		for (int i = 1; i <= 10_000_000; i++) {
			num += i;
			if (num > x) {
				num -= (i);
				break;
			} else if (num == x) {
				odd++;
				break;
			}
			odd++;
		}
		int mo, ja, chi = x-num;
		if(odd%2==0) {
			ja=1+chi; mo = odd-chi;
		}
		else {
			mo=1+chi; ja = odd-chi;
		}
		System.out.println(ja+"/"+mo);
	}
}