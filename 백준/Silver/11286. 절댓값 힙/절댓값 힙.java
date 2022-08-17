import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static int idx = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (Math.abs(o1) == Math.abs(o2)) ? o1-o2 : Math.abs(o1) - Math.abs(o2);
			}
		});

		int num;
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			if(num!=0) {
				que.add(num);				
			}else {
				if(que.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(que.poll());
				}

			}
		}
	}

}