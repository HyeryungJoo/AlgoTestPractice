import java.util.Scanner;

public class SWEA_1861 {

	static int room[][], max, n, cnt, start;
	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			room = new int[n][n];
			max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					room[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dfs(i, j);
					if (cnt >= max) {
						if (cnt == max)
							start = Math.min(start, room[i][j]);
						else
							start = room[i][j];
						max = cnt;
					}
					cnt = 0;
				}
			}

			System.out.printf("#%d %d %d\n", tc, start, max);
		}
	}

	public static void dfs(int i, int j) {
		cnt++;

		for (int k = 0; k < 4; k++) {

			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni >= 0 && ni < n && nj >= 0 && nj < n && room[ni][nj] == room[i][j] + 1) {
				dfs(ni, nj);
			}
		}

		return;

	}

}
