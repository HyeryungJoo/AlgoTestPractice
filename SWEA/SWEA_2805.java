import java.util.Scanner;

public class SWEA_2805 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int n = sc.nextInt();

			int[][] map = new int[n][n];
			int sum = 0;

			for (int i = 0; i < n; i++) {
				String input = sc.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = Math.abs(n / 2 - i); j < n - Math.abs(n / 2 - i); j++) {
					sum += map[i][j];
				}
			}

			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}
