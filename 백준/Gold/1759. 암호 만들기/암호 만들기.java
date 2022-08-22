import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, c;
	static char[] txt;
	static boolean[] select;
	static String mo = "aeiou";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		select = new boolean[c];
		txt = new char[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			txt[i] = st.nextToken().toCharArray()[0];
		}
		Arrays.sort(txt);
		comb(0, 0);
	}

	private static void comb(int idx, int cnt) {
		if (cnt == l) {
			String tmp = "";
			int moc = 0, jac = 0;
			for (int i = 0; i < c; i++) {
				if (select[i]) {
					if (mo.contains(Character.toString(txt[i]))) {
						moc++;
					} else {
						jac++;
					}
					tmp += txt[i];
				}
			}
			if (moc >= 1 && jac >= 2) {
				System.out.println(tmp);
			}
			return;
		}
		if (idx == c)
			return;
		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);
	}

}