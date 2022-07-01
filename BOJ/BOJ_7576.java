import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {

	static int m, n, map[][], cnt;
	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };
	static Queue<int[]> q;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();

		map = new int[n][m];
		q = new LinkedList<int[]>();
		cnt = -1;

		int good = 0;
		int no = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					q.add(new int[] { i, j });
					good++;
				} else if (map[i][j] == -1)
					no++;
			}
		}

		if (good + no != m * n)
			bfs();
		else if (good + no == m * n)
			cnt = 0;

		int bad = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					bad++;
			}
		}

		if (bad != 0)
			cnt = -1;

		System.out.println(cnt);
	}

	public static void bfs() {

		while (!q.isEmpty()) {

			int size = q.size();

			for (int l = 0; l < size; l++) {
				int[] now = q.poll();

				for (int k = 0; k < 4; k++) {
					int ni = now[0] + di[k];
					int nj = now[1] + dj[k];

					if (ni >= 0 && ni < n && nj >= 0 && nj < m && map[ni][nj] == 0) {
						q.add(new int[] { ni, nj });
						map[ni][nj] = 1;
					}
				}
			}
			cnt++;
		}
	}

}
