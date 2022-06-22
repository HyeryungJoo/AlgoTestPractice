import java.util.Scanner;

public class SWEA_5215 {

	static int n, l, max;
	static int[] score, kcal;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			l = sc.nextInt();

			score = new int[n];
			kcal = new int[n];
			max = Integer.MIN_VALUE;
			visit = new boolean[n];

			for (int i = 0; i < n; i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}

			choice(0);

			System.out.printf("#%d %d\n", tc, max);
		}
	}

	public static void choice(int start) {

		if (start == n) {
			int sum_score = 0;
			int sum_kcal = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					sum_kcal += kcal[i];
					sum_score += score[i];
				}
			}

			if (sum_kcal <= l)
				max = Math.max(max, sum_score);
			return;
		}

		visit[start] = true;
		choice(start + 1);
		visit[start] = false;
		choice(start + 1);
	}
}