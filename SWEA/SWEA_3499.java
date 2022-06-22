import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3499 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			Queue<String> left = new LinkedList<String>();
			Queue<String> right = new LinkedList<String>();

			int n = sc.nextInt();
			int half = (int) Math.round(1.0 * n / 2);
			for (int i = 1; i <= n; i++) {
				if (i <= half)
					left.add(sc.next());
				else
					right.add(sc.next());
			}

			System.out.print("#" + tc + " ");
			for (int i = 1; i <= n; i++) {
				if (i % 2 != 0)
					System.out.print(left.poll() + " ");
				else
					System.out.print(right.poll() + " ");
			}
			System.out.println();
		}
	}

}
