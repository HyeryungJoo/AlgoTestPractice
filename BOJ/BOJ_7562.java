import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {

	static int n, startx, starty, endx, endy, ans;
	static boolean[][] visit;
	static int[] di = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dj = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {
			n = sc.nextInt();

			startx = sc.nextInt();
			starty = sc.nextInt();
			endx = sc.nextInt();
			endy = sc.nextInt();
			ans = Integer.MAX_VALUE;
			visit = new boolean[n][n];

			bfs(startx, starty, 0);

			System.out.println(ans);
		}
	}

	public static void bfs(int i, int j, int cnt) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j, cnt });
		visit[i][j] = true;

		while (!q.isEmpty()) {

			int[] now = q.poll();

			if (now[0] == endx && now[1] == endy) {
				ans = Math.min(ans, now[2]);
				break;
			}

			for (int k = 0; k < 8; k++) {

				int ni = now[0] + di[k];
				int nj = now[1] + dj[k];

				if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visit[ni][nj]) {
					visit[ni][nj] = true;
					q.add(new int[] { ni, nj, now[2] + 1 });
				}
			}
		}
	}
}
