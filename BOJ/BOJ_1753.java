import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753 {

	static int v, e, start, ans[];
	static ArrayList<Edge>[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		e = sc.nextInt();
		start = sc.nextInt();

		list = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < e; i++)
			list[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));

		dijkstra();

		for (int i = 1; i <= v; i++) {
			if (ans[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(ans[i]);
		}
	}

	public static void dijkstra() {

		ans = new int[v + 1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {

			Edge edge = pq.poll();

			int curr = edge.to;

			for (Edge out : list[curr]) {
				if (ans[out.to] > ans[curr] + out.weight) {
					ans[out.to] = ans[curr] + out.weight;
					pq.add(new Edge(out.to, ans[out.to]));
				}
			}
		}
	}

	public static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
