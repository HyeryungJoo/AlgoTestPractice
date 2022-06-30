import java.util.Scanner;

public class BOJ_1987 {

	static int r, c, ans;
	static char[][] map;
	static boolean[] visit;
	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();

		visit = new boolean[26];
		map = new char[r][c];

		for (int i = 0; i < r; i++)
			map[i] = sc.next().toCharArray();

		dfs(0, 0, 0);

		System.out.println(ans);
	}

	public static void dfs(int i, int j, int cnt) {

		visit[map[i][j] - 'A'] = true;
		ans = Math.max(ans, cnt + 1);

		for (int k = 0; k < 4; k++) {

			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni >= 0 && ni < r && nj >= 0 && nj < c && !visit[map[ni][nj] - 'A']) {
				dfs(ni, nj, cnt + 1);
			}
		}
		visit[map[i][j] - 'A'] = false;
	}

}
