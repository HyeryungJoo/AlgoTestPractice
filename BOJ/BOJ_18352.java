import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_18352 {

	static int n, m, k, x, ans[];
	static ArrayList<Edge>[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		x = sc.nextInt();

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < m; i++)
			list[sc.nextInt()].add(new Edge(sc.nextInt(), 1));

		dijkstra();

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (ans[i] == k) {
				System.out.println(i);
				cnt++;
			}
		}

		if (cnt == 0)
			System.out.println(-1);
	}

	public static void dijkstra() {

		ans = new int[n + 1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[x] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(x, 0));

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
