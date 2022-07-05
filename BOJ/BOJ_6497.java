import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_6497 {

	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int m = sc.nextInt();
			int n = sc.nextInt();

			if (m == 0 && n == 0)
				break;

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			long sum = 0;

			parent = new int[m];
			for (int i = 0; i < m; i++)
				parent[i] = i;

			for (int i = 0; i < n; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int fee = sc.nextInt();
				pq.add(new Edge(n1, n2, fee));
				sum += fee;
			}

			int cnt = 0;
			long min = 0;
			while (!pq.isEmpty()) {

				Edge edge = pq.poll();

				if (union(edge.n1, edge.n2)) {
					cnt++;
					min += edge.fee;
				}

				if (cnt == m - 1)
					break;
			}

			System.out.println(sum - min);
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
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	public static class Edge implements Comparable<Edge> {
		int n1, n2, fee;

		public Edge(int n1, int n2, int fee) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.fee = fee;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.fee > o.fee)
				return 1;
			else if (this.fee < o.fee)
				return -1;
			return 0;
		}
	}

}
