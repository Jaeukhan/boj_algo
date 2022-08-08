import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt(), idx = -1;
		LinkedList<Integer> ans = new LinkedList<>();
		LinkedList<Integer> map = new LinkedList<>();
		for(int i =1;i<=n;i++) {
			map.add(i);
		}
		while(!map.isEmpty()) {
//			System.out.println(Arrays.toString(map.toArray()));
			idx = (idx+k)%(map.size());
			ans.add(map.get(idx));
			map.remove(idx);
			idx-=1;
//			System.out.println(idx);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0;i<ans.size();i++) {
			if(i==ans.size()-1) {
				sb.append(ans.get(i));				
			}
			else
				sb.append(ans.get(i)+", ");		
		}
		sb.append(">");
		System.out.println(sb);
	}
}