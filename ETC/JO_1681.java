import java.util.Scanner;

public class JO_1681 {

	static int n, map[][], ans, result[];
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new int[n][n];
		ans = Integer.MAX_VALUE;
		visit = new boolean[n];
		result = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		perm(0, 0, 0, 0);

		System.out.println(ans);
	}

	public static void perm(int from, int to, int sum, int cnt) {
		if (ans < sum)
			return;

		if (cnt == n - 1 && map[to][0] != 0) {
			ans = Math.min(ans, sum + map[to][0]);
			return;
		}

		for (int k = 1; k < n; k++) {
			if (!visit[k] && map[to][k] != 0) {
				visit[k] = true;
				result[cnt] = map[to][k];
				perm(to, k, sum + map[to][k], cnt + 1);
				visit[k] = false;
			}
		}

	}
}
