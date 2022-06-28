import java.util.Scanner;

public class BOJ_10026 {

	static char[][] map;
	static int have, not, n;
	static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new char[n][n];
		have = 0;
		not = 0;
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					dfs1(i, j);
					have++;
				}
			}
		}

		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					dfs2(i, j);
					not++;
				}
			}
		}

		System.out.println(not + " " + have);
	}

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void dfs1(int nowi, int nowj) {

		visit[nowi][nowj] = true;

		for (int k = 0; k < 4; k++) {
			int ni = nowi + di[k];
			int nj = nowj + dj[k];

			if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visit[ni][nj]) {
				if (map[nowi][nowj] == 'B' && map[ni][nj] == 'B') {
					dfs1(ni, nj);
				} else if ((map[nowi][nowj] == 'R' || map[nowi][nowj] == 'G')
						&& (map[ni][nj] == 'R' || map[ni][nj] == 'G'))
					dfs1(ni, nj);
			}
		}
	}

	public static void dfs2(int nowi, int nowj) {

		visit[nowi][nowj] = true;
		for (int k = 0; k < 4; k++) {
			int ni = nowi + di[k];
			int nj = nowj + dj[k];

			if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visit[ni][nj] && map[nowi][nowj] == map[ni][nj]) {
				dfs2(ni, nj);
			}
		}
	}
}
