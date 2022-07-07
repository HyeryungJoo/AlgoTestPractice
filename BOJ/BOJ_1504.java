import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1504 {

	static int n, e, ans[];
	static ArrayList<Edge>[] list;
	static final int INF = 200000000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		e = sc.nextInt();

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < e; i++) {

			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();

			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}

		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		// 1 -> v1 -> v2 -> n
		int result1 = 0;
		result1 += dijkstra(1, v1);
		result1 += dijkstra(v1, v2);
		result1 += dijkstra(v2, n);

		// 1 -> v2 -> v1 -> n
		int result2 = 0;
		result2 += dijkstra(1, v2);
		result2 += dijkstra(v2, v1);
		result2 += dijkstra(v1, n);

		int result = 0;
		if (result1 <= INF && result2 <= INF)
			result = Math.min(result1, result2);
		else
			result = -1;

		System.out.println(result);
	}

	public static int dijkstra(int start, int end) {

		ans = new int[n + 1];
		Arrays.fill(ans, INF);
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
		return ans[end];
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
