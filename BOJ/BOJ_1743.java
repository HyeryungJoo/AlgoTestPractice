package test;

import java.util.Scanner;

public class BOJ_1743 {

	public static int n, m, k, map[][], cnt;
	public static boolean visit[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < k; i++)
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					cnt = 0;
					dfs(i, j);
					max = Math.max(max, cnt);
				}
			}
		}

		System.out.println(max);
	}

	public static int di[] = { 0, 0, -1, 1 };
	public static int dj[] = { -1, 1, 0, 0 };

	public static void dfs(int i, int j) {

		visit[i][j] = true;
		cnt++;
		for (int k = 0; k < 4; k++) {

			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni >= 0 && nj >= 0 && ni < n && nj < m && !visit[ni][nj] && map[ni][nj] == 1)
				dfs(ni, nj);
		}
	}
}
