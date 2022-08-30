package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5644 {

	public static int m, a, usera[], userb[];
	public static boolean[][] visit;
	public static ArrayList<int[]> list[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			m = sc.nextInt();
			a = sc.nextInt();

			usera = new int[m];
			userb = new int[m];

			list = new ArrayList[10];
			for (int i = 0; i < 10; i++)
				list[i] = new ArrayList<>();

			for (int i = 0; i < m; i++)
				usera[i] = sc.nextInt();

			for (int i = 0; i < m; i++)
				userb[i] = sc.nextInt();

			for (int i = 0; i < a; i++) {

				visit = new boolean[10][10];
				int bcj = sc.nextInt();
				int bci = sc.nextInt();
				int c = sc.nextInt();
				int p = sc.nextInt();
				list[bci - 1].add(new int[] { bcj - 1, p });
				bfs(bci - 1, bcj - 1, c, p);
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < list[i].size(); j++)
					System.out.print(+list[i].get(j)[0] + " p:"+list[i].get(j)[1]+" //");
				System.out.println();
			}

			System.out.println();
		}
	}

	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void bfs(int i, int j, int c, int p) {

		visit[i][j] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j, 0, p });

		while (!q.isEmpty()) {

			int[] now = q.poll();

			if (now[2] < c) {

				for (int k = 0; k < 4; k++) {

					int ni = now[0] + di[k];
					int nj = now[1] + dj[k];

					if (ni >= 0 && ni < 10 && nj >= 0 && nj < 10 && !visit[ni][nj]) {
						visit[ni][nj] = true;
						list[ni].add(new int[] { nj, p });
						q.add(new int[] { ni, nj, now[2] + 1, p });
					}

				}

			}

		}

	}

}
