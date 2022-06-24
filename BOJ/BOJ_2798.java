import java.util.Scanner;

public class BOJ_2798 {

	static int n, m, card[], ans;
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		card = new int[n];
		visit = new boolean[n];
		ans = 0;

		for (int i = 0; i < n; i++) {
			card[i] = sc.nextInt();
		}

		comb(0, 0);

		System.out.println(ans);
	}

	public static void comb(int start, int cnt) {

		if (cnt == 3) {
			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					sum += card[i];
				}
			}

			if (sum <= m)
				ans = Math.max(ans, sum);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				comb(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}
}
