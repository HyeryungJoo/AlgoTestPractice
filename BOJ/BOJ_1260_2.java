import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_2 {

	static int n, start;
	static boolean visit[];
	static LinkedList<Integer>[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int m = sc.nextInt();
		start = sc.nextInt();

		list = new LinkedList[n + 1];
		visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			list[n1].add(n2);
			list[n2].add(n1);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(list[i]);
		}

		dfs(start);
		System.out.println();
		visit = new boolean[n + 1];
		bfs();
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;

		while (!q.isEmpty()) {

			int now = q.poll();
			System.out.print(now + " ");

			for (int i = 0; i < list[now].size(); i++) {
				if (!visit[list[now].get(i)]) {
					visit[list[now].get(i)] = true;
					q.add(list[now].get(i));
				}
			}
		}
	}

	public static void dfs(int now) {

		System.out.print(now + " ");
		visit[now] = true;

		for (int i = 0; i < list[now].size(); i++) {
			if (!visit[list[now].get(i)]) {
				dfs(list[now].get(i));
			}
		}
	}
}
