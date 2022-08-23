package test;

import java.util.Scanner;

public class BOJ_13458 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long[] room = new long[n];

		for (int i = 0; i < n; i++)
			room[i] = sc.nextLong();

		int b = sc.nextInt();
		int c = sc.nextInt();
		long cnt = 0;

		for (int i = 0; i < n; i++) {
			room[i] -= b;
			if (room[i] > 0) {
				if (room[i] <= c)
					cnt++;
				else if (room[i] % c != 0)
					cnt += (room[i] / c + 1);
				else
					cnt += room[i] / c;
			}
		}

		System.out.println(cnt + n);
	}

}
