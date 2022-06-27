import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_1 {

	static int len, start, map[][], ans, max[];
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			len = sc.nextInt();
			start = sc.nextInt();

			map = new int[101][101];
			visit = new boolean[101];
			max = new int[101];
			Arrays.fill(max, Integer.MAX_VALUE);

			for (int i = 0; i < len / 2; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}

//			bfs();
			dfs(start, 0);

			int max_time = 0;
			for (int i = 1; i < 101; i++) {
				if (max[i] != Integer.MAX_VALUE && max[i] >= max_time) {
					max_time = max[i];
					ans = i;
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	public static void dfs(int now, int cnt) {

		if (max[now] <= cnt)
			return;

		max[now] = cnt;
		for (int i = 1; i < 101; i++) {
			if (map[now][i] == 1) {
				dfs(i, cnt + 1);
			}
		}

	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;

		while (!q.isEmpty()) {

			int size = q.size();
			int max = 0;

			for (int k = 0; k < size; k++) {

				int now = q.poll();
				max = Math.max(max, now);

				for (int i = 1; i < 101; i++) {
					if (!visit[i] && map[now][i] == 1) {
						q.add(i);
						visit[i] = true;
					}
				}
			}
			ans = max;
		}

	}

}
