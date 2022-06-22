import java.util.Scanner;

public class SWEA_1210 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int TC = sc.nextInt();
			int[][] ladder = new int[100][100];
			int starti = 0;
			int startj = 0;
			int ans = -1;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if (ladder[i][j] == 2) {
						starti = i;
						startj = j;
					}
				}
			}

			int[] di = { 0, 0, -1 };
			int[] dj = { 1, -1, 0 };

			while (true) {

				if (starti == 0) {
					ans = startj;
					break;
				}

				ladder[starti][startj] = 0;

				for (int k = 0; k < 3; k++) {

					int ni = starti + di[k];
					int nj = startj + dj[k];

					if (ni >= 0 && ni < 100 && nj >= 0 && nj < 100 && ladder[ni][nj] == 1) {
						starti = ni;
						startj = nj;
						break;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

}
