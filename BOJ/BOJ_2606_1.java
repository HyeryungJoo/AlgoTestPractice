import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2606_1 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		list = new ArrayList[n + 1];
		visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list[a].add(b);
			list[b].add(a);
		}

		dfs(1);

		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (visit[i])
				ans++;
		}

		System.out.println(ans);
	}

	public static void dfs(int now) {

		visit[now] = true;
		for (int i = 0; i < list[now].size(); i++) {
			if (!visit[list[now].get(i)])
				dfs(list[now].get(i));
		}
	}
}
