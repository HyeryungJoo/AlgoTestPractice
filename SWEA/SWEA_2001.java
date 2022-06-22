import java.util.Scanner;

public class SWEA_2001 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int n = sc.nextInt();
			int m = sc.nextInt();
			int max = 0;

			int[][] map = new int[n][n];
			int[][] stick = new int[m][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					int sum = 0;
					for (int k = i; k < i + m; k++) {
						for (int l = j; l < j + m; l++) {
							sum += map[k][l];
						}
					}
					max = Math.max(sum, max);
				}
			}

			System.out.printf("%d %d\n", tc, max);
		}
	}

}
