import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753 {

	static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int e = sc.nextInt();
		int k = sc.nextInt();

		parent = new int[v + 1];
		for (int i = 0; i <= v; i++)
			parent[i] = i;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < e; i++)
			pq.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));

		int cnt = 0;
		int ans = 0;
		while (!pq.isEmpty()) {

			Edge edge = pq.poll();

			if (union(edge.a, edge.b)) {
				cnt++;
				ans += edge.c;
				System.out.println(edge.a + " " + edge.b + " " + edge.c);
			}
		}

		System.out.println(ans);
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
		int a, b, c;

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
