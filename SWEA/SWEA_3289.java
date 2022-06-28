import java.util.Scanner;

public class SWEA_3289 {

	static int n, m, root[];
	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			m = sc.nextInt();
			root = new int[n + 1];
			sb = new StringBuilder();

			for (int i = 1; i <= n; i++)
				root[i] = i;

			for (int i = 0; i < m; i++) {

				int order = sc.nextInt();

				if (order == 0)
					union(sc.nextInt(), sc.nextInt());
				else {
					int a = find(sc.nextInt());
					int b = find(sc.nextInt());
					if (a == b)
						sb.append(1);
					else
						sb.append(0);
				}
			}

			System.out.println("#" + tc + " " + sb.toString());
		}
	}

	public static void union(int a, int b) {

		int aroot = find(a);
		int broot = find(b);

		if (aroot == broot)
			return;

		root[broot] = aroot;
	}

	public static int find(int a) {

		if (root[a] == a)
			return a;

		return root[a] = find(root[a]);
	}
}
