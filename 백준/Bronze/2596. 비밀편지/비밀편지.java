import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] password = {"000000","001111","010011","011100","100110","101001","110101","111010"};
	static String[] alpha = {"A","B","C","D","E","F","G","H"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String txt = br.readLine();
		StringBuilder sb = new StringBuilder();
	
		for(int i=0;i<txt.length();i+=6) {
			String p = txt.substring(i, i+6);
			boolean exist = false;
			for(int j=0;j<password.length;j++) {
				if(p.equals(password[j])||check(p, password[j])) {
					sb.append(alpha[j]);
					exist = true;
					break;
				}
			}
			if(!exist) {
				sb = new StringBuilder();
				sb.append((i/6)+1);
				break;
			}
		}
		System.out.println(sb);
	}
	private static boolean check(String p, String password2) {
		int cnt = 0;
		for(int i=0;i<6;i++) {
			if(p.charAt(i)!=password2.charAt(i)) cnt++;
		}
		return (cnt>1)?false:true; 
	}
}