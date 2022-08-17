import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.Stack;
	
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String txt = br.readLine();
			String tmp = "";
			int ans = 0, i = 0, gob = 1;
			Stack<Integer> st = new Stack<>();
			while (i != txt.length()) {
				char m = txt.charAt(i);
				if (m == '+' || m == '-') {
					if (m == '+') {
						st.add(Integer.parseInt(tmp)*gob);
						tmp = "";
						i++;
					} else {
						st.add(Integer.parseInt(tmp)*gob);
						i++;
						tmp = "";
						if(gob!=-1) {
							gob *= -1;							
						}
					}
				} else {
					tmp += m;
					i++;
				}
			}
			st.add(Integer.parseInt(tmp)*gob);
			while (!st.isEmpty()) {
	//			System.out.println(Arrays.toString(st.toArray()));
				ans += st.pop();
			}
			System.out.println(ans);
	
		}
	}