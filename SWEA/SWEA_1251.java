import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1251 {

	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int n = sc.nextInt();

			int[] x = new int[n];
			int[] y = new int[n];

			for (int i = 0; i < n; i++)
				x[i] = sc.nextInt();

			for (int i = 0; i < n; i++)
				y[i] = sc.nextInt();

			double e = sc.nextDouble();

			parent = new int[n + 1];
			for (int i = 0; i <= n; i++)
				parent[i] = i;

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			int cnt = 0;
			double ans = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					long xx = (long) Math.abs(x[i] - x[j]) * Math.abs(x[i] - x[j]);
					long yy = (long) Math.abs(y[i] - y[j]) * Math.abs(y[i] - y[j]);
					pq.add(new Edge(i, j, (xx + yy) * e));
				}
			}

			while (!pq.isEmpty()) {

				Edge edge = pq.poll();

				if (union(edge.n1, edge.n2)) {
					cnt++;
					ans += edge.fee;
				}

				if (cnt == n - 1)
					break;
			}

			System.out.printf("#%d %.0f\n", tc, ans);

		}
	}

	public static boolean union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		parent[b] = a;
		return true;
	}

	public static int find(int a) {

		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static class Edge implements Comparable<Edge> {

		int n1, n2;
		double fee;

		Edge(int n1, int n2, double fee) {
			this.n1 = n1;
			this.n2 = n2;
			this.fee = fee;
		}

		@Override
		public int compareTo(Edge o) {

			if (this.fee < o.fee)
				return -1;
			else if (this.fee > o.fee)
				return 1;
			return 0;
		}
	}

}
