package test;

import java.util.Scanner;

public class BOJ_1010 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] map = new int[31][31];
		map[1][1] = 1;

		for (int i = 2; i <= 30; i++) {
			for (int j = 1; j <= i; j++)
				map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
		}

		int TC = sc.nextInt();

		for (int i = 0; i < TC; i++) {

			int n = sc.nextInt();
			int k = sc.nextInt();

			System.out.println(map[k][n] + map[k][n + 1]);
		}
	}

}
