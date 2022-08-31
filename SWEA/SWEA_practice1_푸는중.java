package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_practice1 {

	public static int n, map[], result, now;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			n = sc.nextInt();
			map = new int[n + 1];
			result = Integer.MAX_VALUE;
			int sum = 0;

			gate g1 = new gate(sc.nextInt(), sc.nextInt());
			gate g2 = new gate(sc.nextInt(), sc.nextInt());
			gate g3 = new gate(sc.nextInt(), sc.nextInt());

			// 1->2->3
			choose(g1.num, 1, g1.person);
			choose(g2.num, 1, g2.person);
			choose(g3.num, 1, g3.person);
			for (int i = 1; i <= n; i++)
				sum += map[i];
			result = Math.min(result, sum);
			System.out.println(Arrays.toString(map));

			// 1->3->2
			map = new int[n + 1];
			sum = 0;
			choose(g1.num, 1, g1.person);
			choose(g3.num, 1, g3.person);
			choose(g2.num, 1, g2.person);
			for (int i = 1; i <= n; i++)
				sum += map[i];
			result = Math.min(result, sum);
			System.out.println(Arrays.toString(map));

			// 2->1->3
			map = new int[n + 1];
			sum = 0;
			choose(g2.num, 1, g2.person);// [0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0]!
			choose(g1.num, 1, g1.person);// [0, 0, 3, 2, 1, 2, 3, 0, 0, 0, 0]!
			choose(g3.num, 1, g3.person);// [0, 4, 3, 2, 1, 2, 1, 10, 0, 2, 1]!
			for (int i = 1; i <= n; i++)
				sum += map[i];
			result = Math.min(result, sum);
			System.out.println(Arrays.toString(map) + "!");

			// 2->3->1
			map = new int[n + 1];
			sum = 0;
			choose(g2.num, 1, g2.person);
			choose(g3.num, 1, g3.person);
			choose(g1.num, 1, g1.person);
			for (int i = 1; i <= n; i++)
				sum += map[i];
			result = Math.min(result, sum);
			System.out.println(Arrays.toString(map));

			// 3->1->2
			map = new int[n + 1];
			sum = 0;
			choose(g3.num, 1, g3.person);
			choose(g1.num, 1, g1.person);
			choose(g2.num, 1, g2.person);
			for (int i = 1; i <= n; i++)
				sum += map[i];
			result = Math.min(result, sum);
			System.out.println(Arrays.toString(map));

			// 3->2->1
			map = new int[n + 1];
			sum = 0;
			choose(g3.num, 1, g3.person);
			choose(g2.num, 1, g2.person);
			choose(g1.num, 1, g1.person);
			for (int i = 1; i <= n; i++)
				sum += map[i];
			result = Math.min(result, sum);
			System.out.println(Arrays.toString(map));

			System.out.printf("#%d %d\n", tc, result);
		}

	}

	public static void choose(int num, int dist, int people) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { num, dist });
		int cnt = 0;

		while (!q.isEmpty()) {

			int[] now = q.poll();

			if (cnt < people) {
				if (map[now[0]] == 0) {
					map[now[0]] = now[1];
					cnt++;
				}

//				for (int i = 1; i <= n; i++) {
//					if (now[0] + i <= n && map[now[0] + i] == 0) {
//						q.add(new int[] { now[0] + i, now[1] + i, now[2] + now[1] });
//						break;
//					}
//				}
//
//				for (int i = 1; i <= n; i++) {
//					if (now[0] - i > 0 && map[now[0] - i] == 0) {
//						q.add(new int[] { now[0] - i, now[1] + i, now[2] + now[1] });
//						break;
//					}
//				}

				for (int i = 1; i <= n; i++) {
					if (now[0] + i <= n && map[now[0] + i] == 0 && now[0] - i > 0 && map[now[0] - i] == 0) {
						q.add(new int[] { now[0] + i, now[1] + i });
						q.add(new int[] { now[0] - i, now[1] + i });
						break;
					} else if (now[0] - i > 0 && map[now[0] - i] == 0) {
						q.add(new int[] { now[0] - i, now[1] + i });
						break;
					} else if (now[0] + i <= n && map[now[0] + i] == 0) {
						q.add(new int[] { now[0] + i, now[1] + i });
						break;
					}
				}
			}
		}
	}

	public static class gate {
		int num;
		int person;

		public gate(int num, int person) {
			this.num = num;
			this.person = person;
		}
	}

}
