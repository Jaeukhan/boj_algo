import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int moveX = sc.nextInt();
		int moveY = sc.nextInt();
		int locX = sc.nextInt();
		int locY = sc.nextInt();
		int ans = 0;
		while(true) {
			if(locX>100000||locY>100000) {
				ans=-1;
				break;
			}
			else if(locX==locY) {
				ans = locX;
				break;
			}
			else {
				if(locX>locY) {
					locY+=moveY;
				}
				else {
					locX+=moveX;
				}
			}
			
		}
		System.out.println(ans);
	}
}