import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2667 {

	static int n, map[][], cnt;
	static boolean visit[][];
	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new int[n][n];
		visit = new boolean[n][n];
		sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					cnt = 0;
					dfs(i, j);
					result.add(cnt);
					total++;
				}
			}
		}

		Collections.sort(result);
		System.out.println(total);
		for (int c : result) {
			if (c != 0)
				System.out.println(c);
		}
	}

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	public static void dfs(int nowi, int nowj) {

		visit[nowi][nowj] = true;
		cnt++;

		for (int k = 0; k < 4; k++) {

			int ni = nowi + di[k];
			int nj = nowj + dj[k];

			if (ni >= 0 && ni < n && nj >= 0 && nj < n && map[ni][nj] == 1 && !visit[ni][nj])
				dfs(ni, nj);
		}
	}

}
