import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2564 {

	static int home[], w, h, n, map[][], ans[];
	static boolean visit[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		w = sc.nextInt();
		h = sc.nextInt();
		n = sc.nextInt();

		map = new int[h + 1][w + 1];
		visit = new boolean[h + 1][w + 1];
		ans = new int[n + 1];
		Arrays.fill(ans, Integer.MAX_VALUE);

		int count = 1;
		for (int i = 0; i < n; i++) {
			int dir = sc.nextInt();

			if (dir == 1)
				map[0][sc.nextInt()] = count;
			else if (dir == 2)
				map[h][sc.nextInt()] = count;
			else if (dir == 3)
				map[sc.nextInt()][0] = count;
			else if (dir == 4)
				map[sc.nextInt()][w] = count;
			count++;
		}

		for (int i = 1; i < h; i++)
			for (int j = 1; j < w; j++)
				map[i][j] = -5;

		int house_dir = sc.nextInt();
		int house = sc.nextInt();
		home = new int[2];
		if (house_dir == 1) {
			home[0] = 0;
			home[1] = house;
		} else if (house_dir == 2) {
			home[0] = h;
			home[1] = house;
		} else if (house_dir == 3) {
			home[0] = house;
			home[1] = 0;
		} else if (house_dir == 4) {
			home[0] = house;
			home[1] = w;
		}

		if (house_dir == 1 || house_dir == 2) {
			dfs(home[0], home[1], 0);
			visit = new boolean[h + 1][w + 1];
			visit[home[0]][home[1] - 1] = true;
			dfs(home[0], home[1], 0);
		} else {
			dfs(home[0], home[1], 0);
			visit = new boolean[h + 1][w + 1];
			visit[home[0] - 1][home[1]] = true;
			dfs(home[0], home[1], 0);
		}

		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += ans[i];

		System.out.println(sum);
	}

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void dfs(int i, int j, int cnt) {

		visit[i][j] = true;
		if (map[i][j] > 0) {
			ans[map[i][j]] = Math.min(ans[map[i][j]], cnt);
		}

		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni >= 0 && ni <= h && nj >= 0 && nj <= w && !visit[ni][nj] && map[ni][nj] >= 0) {
				dfs(ni, nj, cnt + 1);
			}
		}

	}
}
