import java.util.Scanner;

public class BOJ_1074 {

	static int n, c, r, cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		visit(0, 0, (int) Math.pow(2, n), (int) Math.pow(2, n));
	}

	public static void visit(int si, int sj, int ei, int ej) {

		if (r < si || r >= ei || c < sj || c >= ej) {
			cnt += (ei - si) * (ej - sj);
			return;
		}

		if (ei - si == 1) {
			if (si == r && sj == c) {
				System.out.println(cnt);
				System.exit(0);
			}

			cnt++;
			return;
		}

		int mi = (si + ei) / 2;
		int mj = (sj + ej) / 2;

		visit(si, sj, mi, mj);
		visit(si, mj, mi, ej);
		visit(mi, sj, ei, mj);
		visit(mi, mj, ei, ej);
	}
}
