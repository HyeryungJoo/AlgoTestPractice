import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_1 {

	static int n, start, map[][];
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int m = sc.nextInt();
		start = sc.nextInt();
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			map[n1][n2] = 1;
			map[n2][n1] = 1;
		}

		dfs(start);
		System.out.println();
		visit = new boolean[n + 1];
		bfs();
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;

		while (!q.isEmpty()) {

			int now = q.poll();
			System.out.print(now + " ");

			for (int i = 1; i <= n; i++) {
				if (!visit[i] && map[now][i] == 1) {
					visit[i] = true;
					q.add(i);
				}
			}
		}

	}

	public static void dfs(int now) {

		System.out.print(now + " ");

		visit[now] = true;
		for (int i = 1; i <= n; i++) {
			if (!visit[i] && map[now][i] == 1)
				dfs(i);
		}
	}

}
