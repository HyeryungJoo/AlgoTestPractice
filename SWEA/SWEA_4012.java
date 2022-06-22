import java.util.Scanner;

public class SWEA_4012 {

	static int n, food[][], min;
	static boolean[] choice;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			food = new int[n][n];
			min = Integer.MAX_VALUE;
			choice = new boolean[n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					food[i][j] = sc.nextInt();
				}
			}

			choose(0, 0);

			System.out.printf("#%d %d\n", tc, min);
		}
	}

	public static void choose(int start, int cnt) {

		if (cnt == n / 2) {

			int a_score = 0;
			int b_score = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (choice[i] && choice[j])
						a_score += food[i][j];
					else if (!choice[i] && !choice[j])
						b_score += food[i][j];
				}
			}

			min = Math.min(min, Math.abs(a_score - b_score));

			return;
		}

		if (start == n)
			return;

		choice[start] = true;
		choose(start + 1, cnt + 1);
		choice[start] = false;
		choose(start + 1, cnt);

	}

}
