import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int l, c;
	static char[] arr, results;
	static String mo = "aeiou";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		results = new char[l];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().toCharArray()[0];
		}//input end
		Arrays.sort(arr);
		perm(0, 0,-1);
	}
	private static void perm(int idx, int flag, int before) {
		if(idx==l) {
			String tmp="";
			int mocnt=0, jacnt=0;
			for (int i = 0; i < results.length; i++) {
				if(mo.contains(Character.toString(results[i]))) {
					mocnt ++;
				}else jacnt++;
				tmp+=results[i];
			}
			if(mocnt>=1 && jacnt>=2) {
				System.out.println(tmp);
			}
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if((flag&1<<i)!=0||before>arr[i]-'a') continue;
			results[idx] = arr[i];
			perm(idx+1, flag|1<<i, arr[i]-'a');
		}
	}
}