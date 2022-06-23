import java.util.Scanner;

public class SWEA_1247 {

	static int n, ans;
	static Point[] input, result;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			ans = Integer.MAX_VALUE;
			input = new Point[n + 2];
			result = new Point[n + 2];
			visit = new boolean[n + 2];

			input[0] = new Point(sc.nextInt(), sc.nextInt());
			input[n + 1] = new Point(sc.nextInt(), sc.nextInt());
			result[0] = input[0];
			result[n + 1] = input[n + 1];

			for (int i = 1; i <= n; i++) {
				input[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			perm(1);

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	public static void perm(int cnt) {

		if (cnt == n + 1) {

			int dist = 0;
			for (int i = 0; i < n + 1; i++) {
				dist += Math.abs(result[i].x - result[i + 1].x);
				dist += Math.abs(result[i].y - result[i + 1].y);
			}

			ans = Math.min(ans, dist);

			return;
		}

		for (int i = 1; i < n + 1; i++) {

			if (!visit[i]) {
				visit[i] = true;
				result[cnt] = input[i];
				perm(cnt + 1);
				visit[i] = false;
			}
		}

	}

	static class Point {

		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
