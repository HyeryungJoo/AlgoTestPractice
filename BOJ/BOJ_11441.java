package test;

import java.util.Scanner;

public class BOJ_11441 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] plus = new int[n + 1];

		for (int i = 1; i <= n; i++)
			plus[i] = plus[i - 1] + sc.nextInt();

		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			System.out.println(plus[end] - plus[start - 1]);
		}

	}

}
