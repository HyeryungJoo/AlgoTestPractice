package test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1003 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		int[] fibo_zero = new int[41];
		int[] fibo_one = new int[41];
		fibo_zero[0] = 1;
		fibo_one[1] = 1;

		for (int i = 2; i <= 40; i++) {
			fibo_zero[i] = fibo_zero[i - 2] + fibo_zero[i - 1];
			fibo_one[i] = fibo_one[i - 2] + fibo_one[i - 1];
		}

		for (int i = 0; i < TC; i++) {

			int n = sc.nextInt();

			System.out.println(fibo_zero[n] + " " + fibo_one[n]);
		}
	}

}
