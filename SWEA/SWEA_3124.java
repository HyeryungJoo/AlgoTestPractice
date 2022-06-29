import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_3124 {

	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int v = sc.nextInt();
			int e = sc.nextInt();

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < e; i++) {
				pq.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}

			parent = new int[v + 1];
			for (int i = 0; i <= v; i++)
				parent[i] = i;

			int cnt = 0;
			long ans = 0;
			while (!pq.isEmpty()) {

				Edge edge = pq.poll();

				if (union(edge.a, edge.b)) {
					cnt++;
					ans += edge.c;
				}

				if (cnt == v - 1)
					break;
			}

			System.out.printf("#%d %d\n", tc, ans);
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

	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int c;

		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.c > o.c)
				return 1;
			else if (this.c < o.c)
				return -1;
			return 0;
		}
	}
}
