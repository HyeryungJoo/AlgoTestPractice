package test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1463 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] result = new int[n + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[1] = 0;
		for (int i = 2; i <= n; i++) {

			if (i % 3 == 0)
				result[i] = Math.min(result[i], result[i / 3] + 1);
			if (i % 2 == 0)
				result[i] = Math.min(result[i], result[i / 2] + 1);
			result[i] = Math.min(result[i], result[i - 1] + 1);
		}

		System.out.println(result[n]);
	}

}
