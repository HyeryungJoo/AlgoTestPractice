import java.util.Scanner;

public class SWEA_7465 {

	static int[] root, result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			result = new int[n + 1];
			root = new int[n + 1];
			for (int i = 0; i <= n; i++)
				root[i] = i;

			for (int i = 0; i < m; i++) {

				union(sc.nextInt(), sc.nextInt());
			}

			for (int i = 1; i <= n; i++) {
				result[find(i)]++;
			}

			int cnt = 0;
			for (int i = 0; i <= n; i++) {
				if (result[i] != 0)
					cnt++;
			}

			System.out.printf("#%d %d\n", tc, cnt);

		}

	}

	public static void union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a != b)
			root[b] = a;
	}

	public static int find(int a) {

		if (a == root[a])
			return a;

		return root[a] = find(root[a]);
	}

}
