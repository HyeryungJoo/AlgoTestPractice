import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();
		sb.append("<");

		for (int i = 1; i <= n; i++)
			q.add(i);

		int cnt = 1;
		while (!q.isEmpty()) {

			if (q.size() == 1) {
				sb.append(q.poll());
				break;
			}

			if (cnt == k) {
				sb.append(q.poll()).append(", ");
				cnt = 1;
			} else {
				q.add(q.poll());
				cnt++;
			}
		}

		sb.append(">");
		System.out.println(sb.toString());
	}

}
