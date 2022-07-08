import java.util.Scanner;

public class BOJ_16926 {

	static int n, m, r, map[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < r; i++)
			turn();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void turn() {

		for (int d = 0; d < Math.min(n, m) / 2; d++) {

			int tmp = map[d][d];

			for (int j = d; j < m - d - 1; j++)
				map[d][j] = map[d][j + 1];

			for (int i = d; i < n - d - 1; i++)
				map[i][m - d - 1] = map[i + 1][m - d - 1];

			for (int j = m - d - 1; d < j; j--)
				map[n - d - 1][j] = map[n - d - 1][j - 1];

			for (int i = n - 1 - d; d < i; i--)
				map[i][d] = map[i - 1][d];

			map[d + 1][d] = tmp;
		}
	}
}
