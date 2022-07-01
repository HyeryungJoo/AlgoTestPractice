import java.util.Scanner;

public class BOJ_1992 {

	static StringBuilder sb;
	static int[][] map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		map = new int[n][n];
		sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		visit(0, 0, n, n);
		System.out.println(sb.toString());
	}

	public static void visit(int si, int sj, int ei, int ej) {

		int now = map[si][sj];
		boolean end = false;

		for (int i = si; i < ei; i++) {
			for (int j = sj; j < ej; j++) {
				if (map[i][j] != now) {
					end = true;
					break;
				}
			}

			if (end)
				break;
		}

		if (!end) {
			sb.append(now);
			return;
		}

		int mi = (si + ei) / 2;
		int mj = (sj + ej) / 2;

		sb.append("(");
		visit(si, sj, mi, mj);
		visit(si, mj, mi, ej);
		visit(mi, sj, ei, mj);
		visit(mi, mj, ei, ej);
		sb.append(")");
	}
}
