import java.util.Scanner;

public class BOJ_4963 {

	static int w, h, map[][];
	static int[] di = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dj = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			visit = new boolean[h][w];
			int ans = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						dfs(i, j);
						ans++;
					}
				}
			}

			System.out.println(ans);
		}

	}

	public static void dfs(int nowi, int nowj) {

		visit[nowi][nowj] = true;

		for (int k = 0; k < 8; k++) {
			int ni = nowi + di[k];
			int nj = nowj + dj[k];

			if (ni >= 0 && ni < h && nj >= 0 && nj < w && !visit[ni][nj] && map[ni][nj] == 1)
				dfs(ni, nj);
		}
	}

}
