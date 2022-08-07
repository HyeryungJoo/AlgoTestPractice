package test;

import java.util.Scanner;

public class BOJ_9095 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		int result[] = new int[11];
		result[1] = 1;
		result[2] = 2;
		result[3] = 4;

		for (int i = 4; i <= 10; i++)
			result[i] = result[i - 1] + result[i - 2] + result[i - 3];

		for (int i = 0; i < TC; i++) {
			System.out.println(result[sc.nextInt()]);
		}
	}

}
