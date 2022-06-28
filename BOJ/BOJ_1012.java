import java.util.Scanner;

public class BOJ_1012 {

	static int m, n, k, map[][];
	static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {

			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();

			map = new int[n][m];
			visit = new boolean[n][m];
			int ans = 0;

			for (int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[b][a] = 1;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						dfs(i, j);
						ans++;
					}
				}
			}

			System.out.println(ans);

		}
	}

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void dfs(int nowi, int nowj) {

		visit[nowi][nowj] = true;

		for (int k = 0; k < 4; k++) {
			int ni = nowi + di[k];
			int nj = nowj + dj[k];

			if (ni >= 0 && ni < n && nj >= 0 && nj < m && map[ni][nj] == 1 && !visit[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
}
