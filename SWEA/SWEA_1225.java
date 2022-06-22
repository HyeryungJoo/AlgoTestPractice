import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int TC = sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();

			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}

			int k = 1;
			while (true) {

				int now = q.poll() - k;

				if (now <= 0) {
					q.add(0);
					break;
				}
				q.add(now);

				k++;
				if (k == 6)
					k = 1;
			}

			System.out.printf("#%d ", tc);
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}

}
