package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_4013 {

	public static LinkedList[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int k = sc.nextInt();
			int score = 0;

			list = new LinkedList[4];

			for (int i = 0; i < 4; i++)
				list[i] = new LinkedList<>();

			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 8; j++)
					list[i].add(sc.nextInt());

			for (int i = 0; i < k; i++) {

				int n = sc.nextInt();
				int dir = sc.nextInt();

				turncheck(n - 1, dir);
			}

			for (int i = 0; i < 4; i++) {
				if (list[i].get(0).equals(1))
					score += Math.pow(2, i);
			}

			System.out.printf("#%d %d\n", tc, score);
		}

	}

	public static void turncheck(int n, int dir) {

		Queue<int[]> next = new LinkedList<>();
		int now = dir;

		// 오른쪽으로 확인
		for (int i = n; i < 3; i++) {
			if (!list[i].get(2).equals(list[i + 1].get(6))) {
				next.add(new int[] { i + 1, now * -1 });
				now *= -1;
			} else
				break;
		}

		now = dir;
		// 왼쪽으로 확인
		for (int i = n; i > 0; i--) {
			if (!list[i].get(6).equals(list[i - 1].get(2))) {
				next.add(new int[] { i - 1, now * -1 });
				now *= -1;
			} else
				break;
		}

		turn(n, dir);
		while (!next.isEmpty()) {
			int[] nextturn = next.poll();
			turn(nextturn[0], nextturn[1]);
		}
	}

	public static void turn(int n, int dir) {

		if (dir == 1)
			list[n].add(0, list[n].remove(7));
		else
			list[n].add(list[n].remove(0));
	}
}
