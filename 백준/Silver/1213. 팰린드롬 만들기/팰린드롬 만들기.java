import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] txt = br.readLine().toCharArray();
		int onecnt = 0;
		boolean exit;
		String str="", mid="";
		int[] chr = new int[26];
		for(int i=0;i<txt.length;i++) {
			chr[txt[i]-'A']+=1;
		}
		for(int i=0;i<chr.length;i++) {
			if(chr[i]%2==1) {
				onecnt+=1;
			}
		}
		exit = (onecnt>1)? true:false;
		if(exit) {
			System.out.println("I'm Sorry Hansoo");			
		}else {
			for(int i=0;i<chr.length;i++) {
				if(chr[i]%2==0) {
					for(int j=0;j<chr[i]/2;j++) {
						str+=(char)('A'+i);
					}
				}
				else {
					for(int j=0;j<chr[i]/2;j++) {
						str+=(char)('A'+i);
					}
					mid+=(char)('A'+i);
				}
			}
			String ans = new String(str);
			ans += mid;
			for(int i=str.length()-1;i>=0;i--) {
				ans += str.charAt(i);
			}
			System.out.println(ans);
		}
		
	}
}