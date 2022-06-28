import java.util.Scanner;

public class BOJ_1303 {

	static int n, m, cnt;
	static char map[][];
	static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		map = new char[m][n];
		visit = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			map[i] = sc.next().toCharArray();
		}

		int white = 0;
		int blue = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					cnt = 0;
					dfs(i, j);
					if (map[i][j] == 'W')
						white += cnt * cnt;
					else
						blue += cnt * cnt;
				}
			}
		}

		System.out.println(white + " " + blue);
	}

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void dfs(int nowi, int nowj) {

		visit[nowi][nowj] = true;
		cnt++;

		for (int k = 0; k < 4; k++) {

			int ni = nowi + di[k];
			int nj = nowj + dj[k];

			if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visit[ni][nj] && map[ni][nj] == map[nowi][nowj])
				dfs(ni, nj);
		}

	}

}
