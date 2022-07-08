import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {

	static int r, c, t, map[][];
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		int[] air = new int[2];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1 && air[0] == 0)
					air[0] = i;
				else if (map[i][j] == -1)
					air[1] = i;
			}
		}

		for (int i = 0; i < t; i++) {

			q = new LinkedList<>();

			for (int k = 0; k < r; k++) {
				for (int l = 0; l < c; l++) {
					if (map[k][l] > 0)
						q.add(new int[] { k, l, 0, 0 });
				}
			}

			bfs();
			airup(air[0]);
			airdown(air[1]);

		}

		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != -1)
					sum += map[i][j];
			}
		}

		System.out.println(sum);
	}

	public static void airdown(int n) {

		for (int i = n + 1; i < r - 1; i++)
			map[i][0] = map[i + 1][0];

		for (int j = 0; j < c - 1; j++)
			map[r - 1][j] = map[r - 1][j + 1];

		for (int i = r - 1; i > n; i--)
			map[i][c - 1] = map[i - 1][c - 1];

		for (int j = c - 1; j > 1; j--)
			map[n][j] = map[n][j - 1];

		map[n][1] = 0;
	}

	public static void airup(int n) {

		int tmp = map[0][0];

		for (int j = 0; j < c - 1; j++)
			map[0][j] = map[0][j + 1];

		for (int i = 0; i < n; i++)
			map[i][c - 1] = map[i + 1][c - 1];

		for (int j = c - 1; j > 1; j--)
			map[n][j] = map[n][j - 1];

		for (int i = n - 1; i > 1; i--)
			map[i][0] = map[i - 1][0];

		map[1][0] = tmp;
		map[n][1] = 0;
	}

	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	public static void bfs() {

		while (!q.isEmpty()) {

			int[] now = q.poll();

			if (now[3] == 2)
				break;

			if (now[2] != 0) {
				map[now[0]][now[1]] += now[2];
				now[2] = 0;
			}

			int n = map[now[0]][now[1]] / 5;

			for (int k = 0; k < 4; k++) {

				int ni = now[0] + di[k];
				int nj = now[1] + dj[k];

				if (ni >= 0 && ni < r && nj >= 0 && nj < c && map[ni][nj] != -1) {
					q.add(new int[] { now[0], now[1], now[2] - n, now[3] + 1 });
					q.add(new int[] { ni, nj, n, 0 });
				}
			}
		}
	}
}
