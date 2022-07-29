package test;

import java.util.Scanner;

public class BOJ_2527 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			if (q1 < y2 || q2 < y1 || p1 < x2 || p2 < x1)
				System.out.println("d");
			else if ((x1 == p2 && q1 == y2) || (x2 == p1 && q2 == y1) || (p1 == x2 && q1 == y2)
					|| (p2 == x1 && q2 == y1))
				System.out.println("c");
			else if (q1 == y2 || q2 == y1 || x1 == p2 || x2 == p1)
				System.out.println("b");
			else
				System.out.println("a");

		}
	}

}
