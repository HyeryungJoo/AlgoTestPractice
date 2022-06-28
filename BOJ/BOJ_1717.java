import java.util.Scanner;

public class BOJ_1717 {

	static int[] root;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int m = sc.nextInt();

		root = new int[n + 1];
		for (int i = 0; i <= n; i++)
			root[i] = i;

		for (int i = 0; i < m; i++) {

			int order = sc.nextInt();

			if (order == 0)
				union(sc.nextInt(), sc.nextInt());
			else {

				if (find(sc.nextInt()) == find(sc.nextInt()))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static void union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a != b)
			root[b] = a;
	}

	public static int find(int a) {
		if (root[a] == a)
			return a;
		return root[a] = find(root[a]);
	}

}
