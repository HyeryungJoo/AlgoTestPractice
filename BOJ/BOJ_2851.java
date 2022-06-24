import java.util.Scanner;

public class BOJ_2851 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] score = new int[11];
		for (int i = 1; i <= 10; i++) {
			score[i] = sc.nextInt();
		}

		for (int i = 1; i <= 10; i++) {
			score[i] += score[i - 1];
		}

		int minus = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < 11; i++) {
			if (minus >= Math.abs(100 - score[i])) {
				minus = Math.abs(100 - score[i]);
				if (ans < score[i])
					ans = score[i];
			}
		}

		System.out.println(ans);
	}

}
