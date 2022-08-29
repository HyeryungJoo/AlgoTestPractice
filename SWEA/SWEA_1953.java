package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953 {

	public static int n, m, r, c, l, map[][], cnt;
	public static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			m = sc.nextInt();
			r = sc.nextInt();
			c = sc.nextInt();
			l = sc.nextInt();
			cnt = 0;
			map = new int[n][m];
			visit = new boolean[n][m];

			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					map[i][j] = sc.nextInt();

			bfs(r, c, 1);

			System.out.printf("#%d %d\n", tc, cnt);
		}

	}

	public static int[][] pipe = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 0 },
			{ 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 } };
	public static int[] di = { -1, 0, 1, 0 };
	public static int[] dj = { 0, 1, 0, -1 };

	public static void bfs(int i, int j, int t) {

		visit[i][j] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j, t });

		while (!q.isEmpty()) {

			int[] now = q.poll();
			cnt++;

			if (now[2] < l) {

				for (int k = 0; k < 4; k++) {

					if (pipe[map[now[0]][now[1]]][k] == 1) {

						int ni = now[0] + di[k];
						int nj = now[1] + dj[k];

						if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visit[ni][nj]
								&& pipe[map[ni][nj]][(k + 2) % 4] == 1) {
							visit[ni][nj] = true;
							q.add(new int[] { ni, nj, now[2] + 1 });

						}

					}

				}

			}

		}

	}

}
