package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {

	public static int n, m, map[][], min;
	public static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < m; j++)
				map[i][j] = input.charAt(j) - '0';
		}

		bfs(0, 0, 1);
		System.out.println(min);
	}

	public static int di[] = { 0, 0, -1, 1 };
	public static int dj[] = { -1, 1, 0, 0 };

	public static void bfs(int i, int j, int cnt) {

		visit[i][j] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j, cnt });

		while (true) {

			int[] now = q.poll();

			if (now[0] == n - 1 && now[1] == m - 1) {
				min = Math.min(min, now[2]);
				break;
			}

			for (int k = 0; k < 4; k++) {

				int ni = now[0] + di[k];
				int nj = now[1] + dj[k];

				if (ni >= 0 && nj >= 0 && ni < n && nj < m && map[ni][nj] == 1 && !visit[ni][nj]) {
					visit[ni][nj] = true;
					q.add(new int[] { ni, nj, now[2] + 1 });
				}
			}

		}
	}

}
