package test;

import java.util.Scanner;

public class BOJ_16395 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int map[][] = new int[n + 1][n + 1];
		map[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
			}
		}

		System.out.println(map[n][k]);
	}

}
