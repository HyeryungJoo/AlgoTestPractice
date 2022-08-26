package test;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_practice2 {

	public static int n, map[][], result[], min;
	public static boolean[] visit, ans;
	public static ArrayList<int[]> list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			map = new int[n][n];
			list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] != 0)
						list.add(new int[] { i, j });
				}
			}

			result = new int[list.size()];
			visit = new boolean[list.size()];
			min = Integer.MAX_VALUE;
			perm(0);

			System.out.printf("#%d %d\n", tc, min);
		}
	}

	public static void perm(int cnt) {

		if (cnt == list.size()) {

			ans = new boolean[list.size() / 2 + 1];
			for (int i = 0; i < result.length; i++) {
				if (result[i] > 0)
					ans[result[i]] = true;
				else if (result[i] < 0 && !ans[Math.abs(result[i])]) {
					return;
				}
			}

			int nowi = 0;
			int nowj = 0;
			int sum = 0;
			for (int k = 0; k < result.length; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == result[k]) {

							sum += (Math.abs(nowi - i));
							sum += (Math.abs(nowj - j));

							nowi = i;
							nowj = j;
						}
					}
				}
			}

			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[cnt] = map[list.get(i)[0]][list.get(i)[1]];
				perm(cnt + 1);
				visit[i] = false;
			}
		}

	}

}
