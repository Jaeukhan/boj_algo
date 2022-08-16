import java.util.Scanner;

public class Main {
	static int n,r, c, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		cnt = 0;
		int size = (int) Math.pow(2, n);
		run(size, 0, 0);
	}

	public static void run(int s, int i, int j) {
		if(s==1) {
			System.out.println(cnt);
			return;
		}
		int ns = s/2;
		if(r<i+ns&&c<j+ns) {
			run(ns, i, j);			
		}
		else if(r<i+ns&&j+ns<=c) {
			cnt += (ns*ns);
			run(s/2,i,j+s/2);
		}else if(i+ns<=r&&c<j+ns) {			
			cnt += (ns*ns)*2;
			run(s/2,i+s/2,j);
		}else if(i+ns<=r&&j+ns<=c) {
			cnt += (ns*ns)*3;
			run(s/2,i+s/2,j+s/2);			
		}
	}
}