import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {

	static int n, result[];
	static ArrayList<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		result = new int[n + 1];
		list = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			list[n1].add(n2);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {

			visit = new boolean[n + 1];
			bfs(i);
		}

		for (int i = 1; i <= n; i++)
			max = Math.max(max, result[i]);

		for (int i = 1; i <= n; i++) {
			if (result[i] == max)
				bw.write(i + " ");
		}

		bw.flush();
		bw.close();
	}

	public static void bfs(int now) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(now);
		visit[now] = true;

		while (!q.isEmpty()) {

			int node = q.poll();

			visit[node] = true;
			result[node]++;

			for (int i = 0; i < list[node].size(); i++) {
				if (!visit[list[node].get(i)]) {
					visit[list[node].get(i)] = true;
					q.add(list[node].get(i));
				}
			}

		}
	}

}
