package test;

import java.util.Scanner;

public class BOJ_2581 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int num[] = new int[10001];
		boolean visit[] = new boolean[10001];

		for (int i = 2; i <= 10000; i++) {
			for (int j = i + i; j <= 10000; j += i) {
				if (!visit[j])
					visit[j] = true;
			}
		}

		int cnt = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = m; i <= n; i++) {
			if (!visit[i]) {
				if (i > 1) {
					cnt++;
					sum += i;
					min = Math.min(min, i);
				}
			}
		}
		if (cnt == 0)
			System.out.println(-1);
		else
			System.out.println(sum + "\n" + min);
	}

}
