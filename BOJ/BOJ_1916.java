import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {

	static int n, m, start, end, ans[];
	static ArrayList<Edge>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		visit = new boolean[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijkstra();

		bw.write(ans[end] + "");
		bw.flush();
		bw.close();
	}

	public static void dijkstra() {

		ans = new int[n + 1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {

			Edge edge = pq.poll();

			int curr = edge.to;

			if (visit[curr])
				continue;

			visit[curr] = true;
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
