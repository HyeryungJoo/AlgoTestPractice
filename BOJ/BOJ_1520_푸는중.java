package test;

import java.util.Scanner;

public class BOJ_1520 {

	static int m, n, map[][], cnt;
	static boolean visit[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m][n];
		visit = new boolean[m][n];
		cnt = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);

		System.out.println(cnt);
	}

	static int[] di = { 0, 0, 1 };
	static int[] dj = { -1, 1, 0 };

	public static void dfs(int i, int j) {

		if (i == m - 1 && j == n - 1) {
			cnt++;
			return;
		}

		visit[i][j] = true;
		for (int k = 0; k < 3; k++) {

			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni >= 0 && ni < m && nj >= 0 && nj < n && map[i][j] > map[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
}
