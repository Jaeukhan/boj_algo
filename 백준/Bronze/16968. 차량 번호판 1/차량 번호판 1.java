import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] txt = sc.nextLine().toCharArray();
		int num = 1;
		for(int i=0;i<txt.length;i++) {
			if(i==0) {
				if(txt[i]=='c')
					num*=26;
				else
					num*=10;
			}else {
				if(txt[i-1]==txt[i]) {
					if(txt[i]=='c')
						num*=25;
					else
						num*=9;
				}
				else{
					if(txt[i]=='c')
						num*=26;
					else
						num*=10;
				}
			}
		}
		System.out.println(num);
	}
}