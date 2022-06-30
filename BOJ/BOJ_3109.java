import java.util.Scanner;

public class BOJ_3109 {

	static int r, c, cnt, ans;
	static char[][] map;
	static boolean[][] visit;
	static boolean end;
	static int[] di = { -1, 0, 1 };
	static int[] dj = { 1, 1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();

		map = new char[r][c];
		visit = new boolean[r][c];

		for (int i = 0; i < r; i++)
			map[i] = sc.next().toCharArray();

		for (int i = 0; i < r; i++) {
			if (!visit[i][0] && map[i][0] == '.') {

				end = false;
				dfs(i, 0);

			}
		}

		System.out.println(cnt);
	}

	public static void dfs(int i, int j) {

		if (end)
			return;

		visit[i][j] = true;
		if (j == c - 1) {
			cnt++;
			end = true;
			return;
		}

		for (int k = 0; k < 3; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni >= 0 && ni < r && nj >= 0 && nj < c && !visit[ni][nj] && map[ni][nj] == '.') {
				dfs(ni, nj);
			}
		}
	}

}
