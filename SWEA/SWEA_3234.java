import java.util.Scanner;

public class SWEA_3234 {

	static int n, ans, choo[], total, factorial[], pow[];
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();

			ans = 0;
			total = 0;
			choo = new int[n];
			factorial = new int[n + 1];
			pow = new int[n + 1];
			factorial[0] = pow[0] = 1;
			visit = new boolean[n];

			for (int i = 1; i <= n; i++) {
				choo[i - 1] = sc.nextInt();
				total += choo[i - 1];
				factorial[i] = factorial[i - 1] * i;
				pow[i] = pow[i - 1] * 2;
			}

			choose(0, 0, 0, total);

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	public static void choose(int idx, int left, int right, int remain) {

		if (right + remain <= left) {
			ans += factorial[n - idx] * pow[n - idx];
			return;
		}

		if (idx == n) {
			ans++;
			return;
		}

		for (int i = 0; i < n; i++) {

			if (!visit[i]) {

				visit[i] = true;
				choose(idx + 1, left + choo[i], right, remain - choo[i]);
				if (right + choo[i] <= left)
					choose(idx + 1, left, right + choo[i], remain - choo[i]);
				visit[i] = false;
			}
		}
	}
}
