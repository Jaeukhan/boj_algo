import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		LinkedList<String> ans = new LinkedList<>();
		for(int i=0;i<n;i++) {
			hs.add(br.readLine());
		}
		
		for(int i=0;i<m;i++) {
			String txt = br.readLine();
			if(hs.contains(txt)) {
				ans.add(txt);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}