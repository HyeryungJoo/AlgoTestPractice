import java.util.Scanner;

public class BOJ_2606_2 {

	static int[] root;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		root = new int[n + 1];

		for (int i = 1; i <= n; i++)
			root[i] = i;

		for (int i = 0; i < m; i++) {
			union(sc.nextInt(), sc.nextInt());
		}

		int ans = 0;
		int result = find(1);
		for (int i = 2; i <= n; i++) {
			if (find(i) == result)
				ans++;
		}

		System.out.println(ans);

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
