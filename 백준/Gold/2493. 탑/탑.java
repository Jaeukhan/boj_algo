import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> numinfo = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		int arr[] = new int[n];
//		numinfo.put(Integer.parseInt(st.nextToken()), i+1);
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans[] = new int[n];
		for(int i=arr.length-1;i>=0;i--) {
			if(stack.isEmpty()) {
				stack.push(arr[i]);
				numinfo.put(arr[i], i);
			}
			else {
				if(stack.peek()<=arr[i]) {
					while(!stack.isEmpty()){
						if(stack.peek()<=arr[i]) {
							ans[numinfo.get(stack.peek())] = i+1;
							numinfo.remove(stack.peek());
							stack.pop();
						}
						else
							break;
					}
					stack.push(arr[i]);
					numinfo.put(arr[i], i);
				}
				else {
					stack.push(arr[i]);
					numinfo.put(arr[i], i);
				}
			}
		}
		for(int i =0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
	}
}