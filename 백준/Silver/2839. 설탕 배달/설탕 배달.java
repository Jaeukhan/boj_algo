import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), cnt = 0;
		while(true) {
			if(n<3) break;
			if(n>5&&n%5==3) {
				n-=5;
				cnt+=1;
			}else if(n%5==0) {
				n-=5;
				cnt+=1;
			}else {
				n-=3;
				cnt+=1;
			}
		}
		if(n!=0) {
			System.out.println(-1);			
		}else {
			System.out.println(cnt);
		}
	}
}