import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1228 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			List<Integer> list = new LinkedList<Integer>();

			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}

			int orders = sc.nextInt();
			for (int i = 0; i < orders; i++) {
				String insert = sc.next();
				int next = sc.nextInt();
				int order = sc.nextInt();
				for (int j = 0; j < order; j++) {
					list.add(next, sc.nextInt());
					next++;
				}
			}

			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}
