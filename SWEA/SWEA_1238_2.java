import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_2 {

	static int len, start, ans;
	static LinkedList<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			len = sc.nextInt();
			start = sc.nextInt();

			list = new LinkedList[101];
			visit = new boolean[101];
			ans = 0;

			for (int i = 1; i < 101; i++) {
				list[i] = new LinkedList<>();
			}

			for (int i = 0; i < len / 2; i++) {
				list[sc.nextInt()].add(sc.nextInt());
			}

			bfs();

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;

		while (!q.isEmpty()) {

			int size = q.size();
			int max = 0;

			for (int i = 0; i < size; i++) {

				int now = q.poll();
				max = Math.max(max, now);

				for (int j = 0; j < list[now].size(); j++) {
					if (!visit[list[now].get(j)]) {
						visit[list[now].get(j)] = true;
						q.add(list[now].get(j));
					}
				}
			}

			ans = max;
		}

	}

}
