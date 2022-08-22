package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17086 {

	public static int n, m, map[][], cnt;
	public static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					visit = new boolean[n][m];
					cnt = Integer.MAX_VALUE;
					bfs(i, j);
					result = Math.max(result, cnt);
				}
			}
		}

		System.out.println(result);
	}

	public static int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 };
	public static int[] dj = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void bfs(int i, int j) {

		visit[i][j] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j, 0 });

		while (!q.isEmpty()) {

			int[] now = q.poll();

			for (int k = 0; k < 8; k++) {

				int ni = now[0] + di[k];
				int nj = now[1] + dj[k];

				if (ni >= 0 && nj >= 0 && ni < n && nj < m && map[ni][nj] == 0 && !visit[ni][nj]) {
					visit[ni][nj] = true;
					q.add(new int[] { ni, nj, now[2] + 1 });
				} else if (ni >= 0 && nj >= 0 && ni < n && nj < m && map[ni][nj] == 1 && !visit[ni][nj])
					cnt = Math.min(cnt, now[2] + 1);
			}

		}
	}

}
