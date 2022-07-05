import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1647 {

	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		parent = new int[n + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i <= n; i++)
			parent[i] = i;

		for (int i = 0; i < m; i++)
			pq.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));

		int cnt = 0;
		int ans = 0;
		int max = Integer.MIN_VALUE;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			if (union(edge.n1, edge.n2)) {
				cnt++;
				ans += edge.fee;
				max = Math.max(max, edge.fee);
			}

			if (cnt == n - 1)
				break;
		}

		System.out.println(ans - max);

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
